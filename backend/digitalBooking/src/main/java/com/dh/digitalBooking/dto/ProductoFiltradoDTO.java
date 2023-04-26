package com.dh.digitalBooking.dto;

import java.util.Date;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductoFiltradoDTO {

    private Date fecha_checkin;
    private Date fecha_checkout;
    private Long ciudadId;
    private Long categeoriaId;

}
