package com.dh.digitalBooking.controller;

import com.dh.digitalBooking.dto.CreacionProductoDTO;
import com.dh.digitalBooking.dto.ProductoDTO;
import com.dh.digitalBooking.dto.ProductoFiltradoDTO;
import com.dh.digitalBooking.handler.ResponseHandler;
import com.dh.digitalBooking.model.*;
import com.dh.digitalBooking.service.CaracteristicaProductoService;
import com.dh.digitalBooking.service.CategoriaService;
import com.dh.digitalBooking.service.CiudadService;
import com.dh.digitalBooking.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductoController {

    @Autowired
    public ProductoService productoService;
    @Autowired
    public CategoriaService categoriaService;
    @Autowired
    public CiudadService ciudadService;
    @Autowired
    public CaracteristicaProductoService caracteristicaProductoService;



    @PostMapping("/create")
    public ResponseEntity<Object> addProducto(@RequestBody CreacionProductoDTO producto) {
        ResponseEntity<Object> response;
        if (producto.getProducto().getTitulo() != null) {
            response = ResponseHandler.generateResponse("Product added correctly", HttpStatus.OK, productoService.addProducto(producto));
        } else
            response = ResponseHandler.generateResponse("Product can't be added with a null title", HttpStatus.INTERNAL_SERVER_ERROR, null);

        return response;

    }

    @GetMapping("/listAll")
    public ResponseEntity<Object> listProductos(){
        //System.out.println("Esto imprimiendo");
        return ResponseHandler.generateResponse("Listing all the products...", HttpStatus.OK, productoService.listProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> searchProductoById (@PathVariable Long id) {
        ResponseEntity<Object> response;
        ProductoDTO producto = productoService.searchProducto(id);
        if (id != null && producto != null){
            System.out.println(producto);
            response = ResponseHandler.generateResponse("Product found", HttpStatus.OK, producto);
        }
        else {
            response = ResponseHandler.generateResponse("Product NOT found", HttpStatus.NOT_FOUND, null);
        }
        return response;
    }

    @PutMapping()
    public ResponseEntity<Object> updateProducto(@RequestBody CreacionProductoDTO producto){
        ResponseEntity<Object> response;

        if (producto.getProducto().getId() != null && productoService.searchProducto(producto.getProducto().getId()) != null)
            response = ResponseHandler.generateResponse("Product updated correctly", HttpStatus.OK, productoService.updateProducto(producto));
        else
            response = ResponseHandler.generateResponse("Product NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProducto(@PathVariable Long id) throws Exception {

        ResponseEntity<Object> response;

        if (productoService.searchProducto(id)!= null) {
            productoService.deleteProducto(id);
            response = ResponseHandler.generateResponse("Product Deleted", HttpStatus.OK, null);
        }else {
            response = ResponseHandler.generateResponse("Product NOT found", HttpStatus.NOT_FOUND, null);
        }
        return response;
    }


    @GetMapping("/ProductoByCategoria/{id}")
    public ResponseEntity<Object> searchProductoByCategoriaId (@PathVariable Long id) {
        ResponseEntity<Object> response;
        Optional<Categoria> categoria = categoriaService.searchCategoria(id);
        if (id != null && categoria.isPresent()){
            List<Producto> productos = productoService.searchProductoByCategoria(id);
            response = ResponseHandler.generateResponse("Products in category with id " + id + " found", HttpStatus.OK, productos);
            //System.out.println("Entro al if");
        }
        else {
            response = ResponseHandler.generateResponse("Product NOT found", HttpStatus.NOT_FOUND, null);
            // System.out.println("Entro al else");
        }
        return response;
    }

    @GetMapping("/ProductoByCiudad/{id}")
    public ResponseEntity<Object> searchProductoByCiudadId (@PathVariable Long id) {
        ResponseEntity<Object> response;
        Optional<Ciudad> ciudad = ciudadService.searchCiudad(id);
        if (id != null && ciudad.isPresent()){
            List<Producto> productos = productoService.searchProductoByCiudad(id);
            response = ResponseHandler.generateResponse("Products in city with id" + id + "found", HttpStatus.OK, productos);
        }
        else {
            response = ResponseHandler.generateResponse("Products NOT found", HttpStatus.NOT_FOUND, null);
        }
        return response;
    }

    @GetMapping("/Caracteristicas/{id}")
    public ResponseEntity<Object> searchCaracteristicasProducto(@PathVariable Long id) throws Exception {
        ResponseEntity<Object> response;
        ProductoDTO producto = productoService.searchProducto(id);
        if(producto != null){
            List<Caracteristica> caracteristicas = productoService.searchCaracteristicasProducto(id);
            response = ResponseHandler.generateResponse("Characteristic in product with id: " + id + " found", HttpStatus.OK, caracteristicas);
        } else{
            response = ResponseHandler.generateResponse("Characteristics in product with id: " + id + " NOT found", HttpStatus.NOT_FOUND, null);
        }

        return response;
    }

    //FILTRADO POR FECHAS
    @GetMapping("/ProductoByFechas/{fechaCheckIn}/{fechaCheckOut}")
    public ResponseEntity<Object> searchProductoByFechas (@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaCheckIn, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaCheckOut) throws Exception {
        ProductoFiltradoDTO productoFiltradoDTO = new ProductoFiltradoDTO();
        productoFiltradoDTO.setFecha_checkin(fechaCheckIn);
        productoFiltradoDTO.setFecha_checkout(fechaCheckOut);
        List<Producto> resultados = productoService.searchProductoByFechas(productoFiltradoDTO);
        if(resultados == null ) {
            return ResponseHandler.generateResponse("Products NOT found", HttpStatus.NOT_FOUND, null);
        }
        return ResponseHandler.generateResponse("Products found", HttpStatus.OK, resultados);
    }

    //FILTRO FECHAS Y CIUDAD
    @GetMapping("/ProductoByFechas/{id_ciudad}/{fechaCheckIn}/{fechaCheckOut}")
    public ResponseEntity<Object> searchProductoByFechasYCiudad (@PathVariable Long id_ciudad,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date fechaCheckIn,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaCheckOut) throws Exception {
        ProductoFiltradoDTO productoFiltradoDTO = new ProductoFiltradoDTO();
        productoFiltradoDTO.setCiudadId(id_ciudad);
        productoFiltradoDTO.setFecha_checkin(fechaCheckIn);
        productoFiltradoDTO.setFecha_checkout(fechaCheckOut);
        List<Producto> resultados = productoService.searchProductoByFechasYCiudad(productoFiltradoDTO);
        if(resultados == null ) {
            return ResponseHandler.generateResponse("Products NOT found", HttpStatus.NOT_FOUND, null);
        }
        return ResponseHandler.generateResponse("Products found", HttpStatus.OK, resultados);
    }

    @PostMapping("/testLogin")
    public ResponseEntity<Object> testLogin(@RequestBody Object userData){
        ResponseEntity<Object> response;
        response =  ResponseHandler.generateResponse("TEST LOGIN", HttpStatus.OK, userData);
        /*else
            response = ResponseHandler.generateResponse("Product can't be added with a null title", HttpStatus.INTERNAL_SERVER_ERROR, null);
        */
        return response;
    }

    @GetMapping("/productosFiltersTest")
    public ResponseEntity<Object> listProductosFilters(@RequestParam Map<String, String> filters){
        filters.forEach((a,b) -> {
            System.out.println(String.format("%s -> %s",a,b));
        });
        ProductoDTO producto = productoService.searchProducto(3L);
        return ResponseHandler.generateResponse("Listing all the products...", HttpStatus.OK, productoService.listProductos());
    }
}
