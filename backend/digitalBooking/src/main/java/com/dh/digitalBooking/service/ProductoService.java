package com.dh.digitalBooking.service;

import com.dh.digitalBooking.dto.CreacionProductoDTO;
import com.dh.digitalBooking.dto.ProductoDTO;
import com.dh.digitalBooking.dto.ProductoFiltradoDTO;
import com.dh.digitalBooking.model.*;
import com.dh.digitalBooking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CiudadRepository ciudadRepository;
    private final CategoriaRepository categoriaRepository;
    private final CaracteristicaRepository caracteristicaRepository;
    private final CaracteristicaProductoRepository caracteristicaProductoRepository;
    private final UsuarioRepository usuarioRepository;

    private final ImagenRepository imagenRepository;

    private final StorageService storageService;

    private final ImagenService imagenService;

    private final CaracteristicaService caracteristicaService;

    @Autowired
    public ProductoService(ProductoRepository productoRepository, CiudadRepository ciudadRepository, CategoriaRepository categoriaRepository, CaracteristicaRepository caracteristicaRepository, CaracteristicaProductoRepository caracteristicaProductoRepository, UsuarioRepository usuarioRepository, ImagenRepository imagenRepository, StorageService storageService, ImagenService imagenService, CaracteristicaService caracteristicaService) {
        this.productoRepository = productoRepository;
        this.ciudadRepository = ciudadRepository;
        this.categoriaRepository = categoriaRepository;
        this.caracteristicaRepository = caracteristicaRepository;
        this.caracteristicaProductoRepository = caracteristicaProductoRepository;
        this.usuarioRepository = usuarioRepository;
        this.imagenRepository = imagenRepository;
        this.storageService = storageService;
        this.imagenService = imagenService;
        this.caracteristicaService = caracteristicaService;
    }

    //AGREGAR
    public Producto addProducto(CreacionProductoDTO creacionProducto){
        Producto producto = new Producto();
        Optional<Ciudad> ciudad = ciudadRepository.findById(creacionProducto.getProducto().getCiudad().getId());
        producto.setCiudad(ciudad.get());
        Optional<Categoria> categoria = categoriaRepository.findById((creacionProducto.getProducto().getCategoria().getId()));
        producto.setCategoria(categoria.get());
        Optional<Usuario> usuario = usuarioRepository.findById(creacionProducto.getProducto().getUsuario().getId());
        producto.setUsuario(usuario.get());
        producto.setTitulo(creacionProducto.getProducto().getTitulo());
        producto.setUbicacion(creacionProducto.getProducto().getUbicacion());
        producto.setDescripcion(creacionProducto.getProducto().getDescripcion());
        producto.setDireccion(creacionProducto.getProducto().getDireccion());
        producto.setLatitud(creacionProducto.getProducto().getLatitud());
        producto.setLongitud(creacionProducto.getProducto().getLongitud());
        producto.setNormasDeLaCasa(creacionProducto.getProducto().getNormasDeLaCasa());
        producto.setSeguridad(creacionProducto.getProducto().getSeguridad());
        producto.setCancelacion(creacionProducto.getProducto().getCancelacion());

        productoRepository.save(producto);

        List<UploadBean> imgs = creacionProducto.getImagenes();

        for(int i = 0; i< imgs.size(); i++){
            String url = "";
            try {
                url = storageService.store(imgs.get(i));
            } catch (Exception e) {
                throw e;
            }
            if(i == 0){
                producto.setUrlImagenPrincipal(url);
                productoRepository.save(producto);
                continue;
            }
            Imagen imagenCargada = new Imagen(imgs.get(i).getName(), url, producto);
            imagenService.addImagen(imagenCargada);
        }

        return producto;
    }

    //LISTAR TODOS
    public List<Producto> listProductos(){
        List<Producto> productos =  productoRepository.findAll();
        return productos;
    }

    //EDITAR
    public Producto updateProducto(CreacionProductoDTO creacionProducto){
        Producto producto = new Producto();
        Optional<Ciudad> ciudad = ciudadRepository.findById(creacionProducto.getProducto().getCiudad().getId());
        producto.setCiudad(ciudad.get());
        Optional<Categoria> categoria = categoriaRepository.findById((creacionProducto.getProducto().getCategoria().getId()));
        producto.setCategoria(categoria.get());
        Optional<Usuario> usuario = usuarioRepository.findById(creacionProducto.getProducto().getUsuario().getId());
        producto.setUsuario(usuario.get());
        producto.setTitulo(creacionProducto.getProducto().getTitulo());
        producto.setUbicacion(creacionProducto.getProducto().getUbicacion());
        producto.setDescripcion(creacionProducto.getProducto().getDescripcion());
        producto.setDireccion(creacionProducto.getProducto().getDireccion());
        producto.setLatitud(creacionProducto.getProducto().getLatitud());
        producto.setLongitud(creacionProducto.getProducto().getLongitud());
        producto.setNormasDeLaCasa(creacionProducto.getProducto().getNormasDeLaCasa());
        producto.setSeguridad(creacionProducto.getProducto().getSeguridad());
        producto.setCancelacion(creacionProducto.getProducto().getCancelacion());

        productoRepository.save(producto);

        List<UploadBean> imgs = creacionProducto.getImagenes();

        for(int i = 0; i< imgs.size(); i++){
            String url = "";
            try {
                url = storageService.store(imgs.get(i));
            } catch (Exception e) {
                throw e;
            }
            if(i == 0){
                producto.setUrlImagenPrincipal(url);
                productoRepository.save(producto);
                continue;
            }
            Imagen imagenCargada = new Imagen(imgs.get(i).getName(), url, producto);
            imagenService.addImagen(imagenCargada);
        }

        return producto;
    }

    //BUSCAR POR ID
    public ProductoDTO searchProducto(Long id){
        Optional<Producto> p = productoRepository.findById(id);
        if(p.isPresent()) {
            ProductoDTO productoDto = ProductoDTO.convertToDTO(p.get());
            for(CaracteristicaProducto caracProd : p.get().getCaracteristicas()){
                productoDto.getCaracteristicas().add(caracProd.getCaracteristica());
            }
            return productoDto;
        }

        return null;
    }

    //ELIMINAR
    public void deleteProducto(Long id) throws Exception{
        ProductoDTO searchedProducto = searchProducto(id);
        if(searchedProducto != null) productoRepository.deleteById(id);
        else throw new Exception("Missing: Deleting product not found");
    }

    //BUSCAR POR CATEGORIA
    public List<Producto> searchProductoByCategoria(Long id){
        return productoRepository.findByCategoriaId(id);
    }

    //BUSCAR POR CIUDAD
    public List<Producto> searchProductoByCiudad(Long id){
        return productoRepository.findByCiudadId(id);
    }

    //BUSCAR CARACTERISITCAS DE UN PRODUCTO
    public List<Caracteristica> searchCaracteristicasProducto(Long id) throws Exception {
        ProductoDTO searchedProducto = searchProducto(id);
        List<Long> idCaracteristicas;
        List<Caracteristica> caracteristicas;
        if(searchedProducto != null) {
            idCaracteristicas = caracteristicaProductoRepository.findByProducto_Id(id);
            caracteristicas = caracteristicaRepository.findAllById(idCaracteristicas);
            return caracteristicas;
        }
        else
            throw new Exception("Missing: Product with id " + id + " not found");
    }

    //BUSCAR POR FECHAS
    public List<Producto> searchProductoByFechas(ProductoFiltradoDTO producto) throws Exception{
        Date now = new Date();
        if(producto.getFecha_checkin()==null || producto.getFecha_checkout()== null){
            throw new Exception("ERROR: dates entered are null.");
        }
        if(!(producto.getFecha_checkout().toInstant().isAfter(producto.getFecha_checkin().toInstant()))){
            throw new Exception("ERROR: dates are in wrong order.");
        }
        if(now.after(producto.getFecha_checkin())){
            throw new Exception("ERROR: Check-In date cannot be before today's date.");
        }
        List<Producto> resultado = productoRepository.findByFechas(producto.getFecha_checkin(), producto.getFecha_checkout());

        if(resultado == null) throw new Exception("No products available in date range.");

        else return  resultado;
    }

    //BUSCAR POR FECHAS Y CIUDAD
    public List<Producto> searchProductoByFechasYCiudad(ProductoFiltradoDTO producto) throws Exception{
        Date now = new Date();
        if(producto.getFecha_checkin()==null || producto.getFecha_checkout()== null || producto.getCiudadId() == null){
            throw new Exception("ERROR: dates or city entered are null");
        }
        if(!(producto.getFecha_checkout().toInstant().isAfter(producto.getFecha_checkin().toInstant()))){
            throw new Exception("ERROR: dates are in wrong order.");
        }
        if(now.after(producto.getFecha_checkin())){
            throw new Exception("ERROR: Check-In date cannot be before today's date.");
        }
        List<Producto> resultado = productoRepository.findByFechasyCiudad(producto.getCiudadId(),producto.getFecha_checkin(), producto.getFecha_checkout());

        if(resultado == null) throw new Exception("No products available in date range.");

        else return  resultado;
    }


}
