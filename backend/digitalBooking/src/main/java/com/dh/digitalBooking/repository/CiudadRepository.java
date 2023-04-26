package com.dh.digitalBooking.repository;

import com.dh.digitalBooking.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
}
