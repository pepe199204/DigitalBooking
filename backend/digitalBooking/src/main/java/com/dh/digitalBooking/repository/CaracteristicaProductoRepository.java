package com.dh.digitalBooking.repository;


import com.dh.digitalBooking.model.CaracteristicaProducto;
import com.dh.digitalBooking.model.CaracteristicaProductoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CaracteristicaProductoRepository extends JpaRepository<CaracteristicaProducto, CaracteristicaProductoKey> {

    @Query(
            value = "select id_caracteristica from caracteristicas_producto id_caracteristica " +
                    "where id_caracteristica.id_producto = (?1) ;", nativeQuery = true)
    List<Long> findByProducto_Id(Long id_producto);

    @Query(
            value = "select id_producto from caracteristicas_producto id_producto " +
                    "where id_producto.id_caracteristica = (?1); ", nativeQuery = true)
    List<Long> findByCaracteristicaId(Long id_caracteristica);

}
