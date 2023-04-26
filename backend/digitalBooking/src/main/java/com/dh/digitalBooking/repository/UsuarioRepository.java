package com.dh.digitalBooking.repository;

import com.dh.digitalBooking.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNombre(String nombre);
    Usuario findByEmail(String email);

}
