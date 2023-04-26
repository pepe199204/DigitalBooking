package com.dh.digitalBooking.service;


import com.dh.digitalBooking.model.Caracteristica;
import com.dh.digitalBooking.model.CaracteristicaProducto;
import com.dh.digitalBooking.model.Producto;
import com.dh.digitalBooking.repository.CaracteristicaProductoRepository;
import com.dh.digitalBooking.repository.CaracteristicaRepository;
import com.dh.digitalBooking.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicaService {
    private final CaracteristicaRepository caracteristicaRepository;
    private final ProductoRepository productoRepository;
    private final CaracteristicaProductoRepository caracteristicaProductoRepository;

    @Autowired
    public CaracteristicaService(CaracteristicaRepository caracteristicaRepository,ProductoRepository productoRepository ,CaracteristicaProductoRepository caracteristicaProductoRepository) {
        this.caracteristicaRepository = caracteristicaRepository;
        this.productoRepository = productoRepository;
        this.caracteristicaProductoRepository = caracteristicaProductoRepository;
    }

    //AGREGAR
    public Caracteristica addCaracterisitca(Caracteristica caracteristica){
        return caracteristicaRepository.save(caracteristica);
    }

    //LISTAR TODAS
    public List<Caracteristica> listCaracteristica(){
        List<Caracteristica> caracteristicas = caracteristicaRepository.findAll();
        return caracteristicas;
    }

    //EDITAR
    public Caracteristica updateCaracteristica(Caracteristica caracteristica){
        return caracteristicaRepository.save(caracteristica);
    }

    //BUSCAR POR ID
    public Optional<Caracteristica> searchCaracteristica(Long id){
        return caracteristicaRepository.findById(id);
    }

    //ELIMINAR
    public void deleteCaracteristica(Long id) throws Exception{
        Optional<Caracteristica> searchedCaracteristica = searchCaracteristica(id);
        if (searchedCaracteristica.isPresent())
            caracteristicaRepository.deleteById(id);
        else
            throw new Exception("Missing: Deleting characteristic not found");
    }

    //BUSCAR PROUCTOS DE UNA CARACTERISTICA
    public List<Producto> searchProductosCaracteristica(Long id) throws Exception {
        Optional<Caracteristica> searchedCaracteristica = searchCaracteristica(id);
        List<Long> idProductos;
        List<Producto> productos;
        if (searchedCaracteristica.isPresent()) {
            idProductos = caracteristicaProductoRepository.findByCaracteristicaId(id);
            productos = productoRepository.findAllById(idProductos);
            return productos;
        } else
            throw new Exception("Missing: Characteristic with id " + id + " not found");
    }


}
