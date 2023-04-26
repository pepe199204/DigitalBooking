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
@Table(name = "imagenes")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String url_imagen;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public Imagen(String titulo, String url_imagen, Producto producto) {
        this.titulo = titulo;
        this.url_imagen = url_imagen;
        this.producto = producto;
    }
}
