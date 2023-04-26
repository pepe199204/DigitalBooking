package com.dh.digitalBooking.dto;

import com.dh.digitalBooking.model.Rol;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Data
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationDTOResponse {

    String jwt;
    String nombre;
    String apellido;
    String email;
    Long id;
    Rol rol;
}