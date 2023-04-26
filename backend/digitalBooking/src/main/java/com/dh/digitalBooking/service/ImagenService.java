package com.dh.digitalBooking.service;

import com.dh.digitalBooking.model.Imagen;
import com.dh.digitalBooking.model.Producto;
import com.dh.digitalBooking.repository.ImagenRepository;
import com.dh.digitalBooking.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenService {

    private final ImagenRepository imagenRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public ImagenService(ImagenRepository imagenRepository, ProductoRepository productoRepository) {
        this.imagenRepository = imagenRepository;
        this.productoRepository = productoRepository;
    }

    //AGREGAR
    public Imagen addImagen (Imagen imagen){
        Optional<Producto> producto = productoRepository.findById(imagen.getProducto().getId());
        imagen.setProducto(producto.get());
        return imagenRepository.save(imagen);
    }

    //LISTAR TODAS
    public List<Imagen> listImagen(){
        List<Imagen> imagenes = imagenRepository.findAll();
        return imagenes;
    }

    //EDITAR
    public Imagen updateImagen(Imagen imagen){
        Optional<Producto> producto = productoRepository.findById(imagen.getProducto().getId());
        imagen.setProducto(producto.get());
        return imagenRepository.save(imagen);
    }

    //BUSCAR POR ID
    public Optional<Imagen> searchImagen(Long id){
        return imagenRepository.findById(id);
    }

    public List<Imagen> searchImagesByProductId(Long id){
        return imagenRepository.findByProductoId(id);
    }

    //ELIMINAR
    public void deleteImagen (Long id) throws Exception {
        Optional<Imagen> searchedImagen = searchImagen(id);
        if (searchedImagen.isPresent())
            imagenRepository.deleteById(id);
        else
            throw new Exception("Missing: Deleting image not found");
    }





}
