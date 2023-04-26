package com.dh.digitalBooking.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Data
@Embeddable
public class CaracteristicaProductoKey implements Serializable {

    @Column(name= "id_producto")
    private Long productoId;

    @Column(name= "id_caracteristica")
    private Long caracteristicaId;

}
