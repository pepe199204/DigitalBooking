package com.dh.digitalBooking.repository;

import com.dh.digitalBooking.model.Rol;

import com.dh.digitalBooking.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol findByNombre(String nombre);
}
