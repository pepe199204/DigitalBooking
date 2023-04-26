package com.dh.digitalBooking.model;

import lombok.*;
import javax.persistence.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ciudades")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;

}
