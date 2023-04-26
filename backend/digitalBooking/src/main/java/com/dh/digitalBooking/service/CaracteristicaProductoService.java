package com.dh.digitalBooking.service;

import com.dh.digitalBooking.model.Caracteristica;
import com.dh.digitalBooking.model.CaracteristicaProducto;
import com.dh.digitalBooking.model.CaracteristicaProductoKey;
import com.dh.digitalBooking.model.Producto;
import com.dh.digitalBooking.repository.CaracteristicaProductoRepository;
import com.dh.digitalBooking.repository.CaracteristicaRepository;
import com.dh.digitalBooking.repository.ProductoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class CaracteristicaProductoService {

    private final CaracteristicaProductoRepository caracteristicaProductoRepository;
    private final ProductoRepository productoRepository;
    private final CaracteristicaRepository caracteristicaRepository;

    @Autowired
    public CaracteristicaProductoService(CaracteristicaProductoRepository productoCaracteristicaRepository, ProductoRepository productoRepository, CaracteristicaRepository caracteristicaRepository) {
        this.caracteristicaProductoRepository = productoCaracteristicaRepository;
        this.productoRepository = productoRepository;
        this.caracteristicaRepository = caracteristicaRepository;
    }


    public CaracteristicaProducto addCaracteristicaProducto(Long productoId, Long caracteristicaId){
        CaracteristicaProducto caracteristicaProducto = new CaracteristicaProducto();
        caracteristicaProducto.setId(new CaracteristicaProductoKey(productoId, caracteristicaId));
        System.out.println("se seteo el id " + caracteristicaProducto.getId());
        Optional<Producto> producto = productoRepository.findById(productoId);
        caracteristicaProducto.setProducto(producto.get());
        Optional<Caracteristica> caracteristica = caracteristicaRepository.findById(caracteristicaId);
        caracteristicaProducto.setCaracteristica(caracteristica.get());
        log.info("Se agrego la relacion entre productos y caracteristicas");
        return caracteristicaProductoRepository.save(caracteristicaProducto);
    }

    public List<CaracteristicaProducto> listCaracProd(){

        List<CaracteristicaProducto> caractProd = caracteristicaProductoRepository.findAll();

        return caractProd;
    }

}
