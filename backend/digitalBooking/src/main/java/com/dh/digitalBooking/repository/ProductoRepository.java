package com.dh.digitalBooking.repository;

import com.dh.digitalBooking.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoriaId(Long id_categoria);

    List<Producto> findByCiudadId(Long id_ciudad);

    @Query(value = "SELECT p.* FROM productos p WHERE  p.id NOT IN (SELECT DISTINCT " +
            "b.id_producto" +
            "        FROM" +
            "            reservas b" +
            "        WHERE" +
            "            ((b.fecha_checkin >= (?1)" +
            "                AND (?1) <= b.fecha_checkout)" +
            "                OR (b.fecha_checkin <= (?2)" +
            "                AND (?2) <= b.fecha_checkout)" +
            "                OR ((?1) >= b.fecha_checkin" +
            "                AND b.fecha_checkout <= (?2) )));", nativeQuery = true)
    List<Producto> findByFechas(Date fechaCheckIn, Date fechaCheckOut);

    @Query(
            value = "select P.* from productos P " +
                    "where P.id_ciudad = (?1) " +
                    "and P.id not in( "+
                    "select distinct R.id_producto "+
                    "from reservas R "+
                    "where ((R.fecha_checkin >= (?1) " +
                    "AND (?1) <= R.fecha_checkout) " +
                    "OR (R.fecha_checkin <= (?2) " +
                    "AND (?2) <= R.fecha_checkout) " +
                    "OR ((?1) >= R.fecha_checkin " +
                    "AND R.fecha_checkout <= (?2) )));", nativeQuery = true)
    List<Producto> findByFechasyCiudad(Long id_ciudad, Date fechaCheckIn, Date fechaCheckOut);
}
