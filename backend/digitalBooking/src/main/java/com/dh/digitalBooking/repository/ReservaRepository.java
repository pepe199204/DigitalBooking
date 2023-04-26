package com.dh.digitalBooking.repository;

import com.dh.digitalBooking.model.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByProductoId(Long id);

    @Query(
            value = "select R.fecha_checkin, R.fecha_checkout, R.id_producto from reservas R " +
                    "where R.id_producto = (?1); ", nativeQuery = true)
    List<List<String>> searchFechasReservadas(Long id);

    List<Reserva> findByUsuarioId(Long id);

}
