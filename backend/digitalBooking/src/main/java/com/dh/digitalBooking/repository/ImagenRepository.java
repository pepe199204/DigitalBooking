package com.dh.digitalBooking.repository;

import com.dh.digitalBooking.model.Imagen;
import com.dh.digitalBooking.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ImagenRepository extends JpaRepository<Imagen, Long> {

    List<Imagen> findByProductoId(Long id);
}
