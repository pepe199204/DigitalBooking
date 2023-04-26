package com.dh.digitalBooking.controller;


import com.dh.digitalBooking.dto.CaractProdDTO;
import com.dh.digitalBooking.handler.ResponseHandler;
import com.dh.digitalBooking.model.CaracteristicaProducto;
import com.dh.digitalBooking.service.CaracteristicaProductoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/caracteristicas_producto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CaracteristicaProductoController {

    @Autowired
    private CaracteristicaProductoService caracteristicaProductoService;

    @PostMapping("/addCaracteristicaProducto")
    public ResponseEntity<Object> agregarProdCaract(@RequestBody CaractProdDTO caractProdDTO){
        if(caractProdDTO.getProductoId() == null || caractProdDTO.getCaracteristicaId() == null){
            return ResponseHandler.generateResponse("Id nulos", HttpStatus.NOT_FOUND, "No se pudo agregar");
        }
        return ResponseHandler.generateResponse("La relación producto y característica se ha agregado correctamente", HttpStatus.OK, caracteristicaProductoService.addCaracteristicaProducto(caractProdDTO.getProductoId(), caractProdDTO.getCaracteristicaId()));
    }

    @GetMapping("/findAll")
    public ResponseEntity<Object> buscarTodasProdCaract(){
        return ResponseHandler.generateResponse("Listado de todas las relaciones productos y características", HttpStatus.OK,  caracteristicaProductoService.listCaracProd());
    }
}
