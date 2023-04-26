package com.dh.digitalBooking.dto;

import com.dh.digitalBooking.model.Producto;
import com.dh.digitalBooking.model.UploadBean;
import lombok.*;


import java.util.List;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreacionProductoDTO {

    private Producto producto;
    private List<UploadBean> imagenes;
}
