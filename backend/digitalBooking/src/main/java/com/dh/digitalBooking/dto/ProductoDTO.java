package com.dh.digitalBooking.dto;

import com.dh.digitalBooking.model.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Long id;
    private String titulo;
    private String urlImagenPrincipal;
    private String ubicacion;
    private String descripcion;
    private String direccion;
    private Double latitud;
    private Double longitud;
    private String normasDeLaCasa;
    private String seguridad;
    private String cancelacion;
    private Usuario usuario;
    private Ciudad ciudad;
    private Categoria categoria;
    private List<Caracteristica> caracteristicas = new ArrayList<>();


    public static ProductoDTO convertToDTO(Producto producto){
        ProductoDTO productoDTO = new ProductoDTO(producto.getId(), producto.getTitulo(), producto.getUrlImagenPrincipal(), producto.getUbicacion(),
                producto.getDescripcion(), producto.getDireccion(), producto.getLatitud(), producto.getLongitud(), producto.getNormasDeLaCasa(),
                producto.getSeguridad(), producto.getCancelacion(), producto.getUsuario(), producto.getCiudad(),
                producto.getCategoria(), new ArrayList<Caracteristica>());
        return productoDTO;
    }
}
