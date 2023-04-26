package com.dh.digitalBooking.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "caracteristicas")
public class Caracteristica {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String url_icono;

//    @OneToMany(mappedBy = "caracteristica", fetch = FetchType.EAGER)
//    @JsonIgnore
//    private List<CaracteristicaProducto> productos = new ArrayList<>();

}
