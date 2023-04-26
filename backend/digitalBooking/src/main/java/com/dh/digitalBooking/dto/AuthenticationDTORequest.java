package com.dh.digitalBooking.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationDTORequest {

    String email;
    String password;
}
