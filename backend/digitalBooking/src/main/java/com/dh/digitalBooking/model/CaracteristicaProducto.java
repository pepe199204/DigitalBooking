package com.dh.digitalBooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "caracteristicas_producto")
public class CaracteristicaProducto {

    @EmbeddedId
    private CaracteristicaProductoKey id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("id_caracteristica")
    @JsonIgnore
    @JoinColumn(name = "id_caracteristica")
    private Caracteristica caracteristica;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("id_producto")
    @JsonIgnore
    @JoinColumn(name = "id_producto")
    private Producto producto;

}
