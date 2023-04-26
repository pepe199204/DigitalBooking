package com.dh.digitalBooking.controller;

import com.dh.digitalBooking.handler.ResponseHandler;
import com.dh.digitalBooking.model.Imagen;
import com.dh.digitalBooking.model.Provincia;
import com.dh.digitalBooking.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/imagenes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    @PostMapping
    public ResponseEntity<Object> addImagen(@RequestBody Imagen imagen){
        ResponseEntity<Object> response;
        if (imagen.getTitulo() != null)
            response = ResponseHandler.generateResponse("Image added correctly", HttpStatus.OK, imagenService.addImagen(imagen));
        else
            response = ResponseHandler.generateResponse("Image can't be added without a title", HttpStatus.INTERNAL_SERVER_ERROR,null);

        return response;
    }

    @GetMapping()
    public ResponseEntity<Object> listImagenes(){
        return ResponseHandler.generateResponse("Listing all the images...", HttpStatus.OK, imagenService.listImagen());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> searchImagen(@PathVariable Long id){
        ResponseEntity<Object> response;

        if (id != null && imagenService.searchImagen(id).isPresent())
            response = ResponseHandler.generateResponse("Image found", HttpStatus.OK, imagenService.searchImagen(id));
        else
            response = ResponseHandler.generateResponse("Image NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Object> searchImagesByProductId(@PathVariable Long id){
        ResponseEntity<Object> response;
        if (id != null) {
            List<Imagen> images = imagenService.searchImagesByProductId(id);
            response = ResponseHandler.generateResponse("Images found", HttpStatus.OK, images);
        } else {
            response = ResponseHandler.generateResponse("Image NOT found",HttpStatus.NOT_FOUND,null);
        }
        return response;
    }

    @PutMapping()
    public ResponseEntity<Object> updateImagen(@RequestBody Imagen imagen){
        ResponseEntity<Object> response;
        if (imagen.getId() != null && imagenService.searchImagen(imagen.getId()).isPresent())
            response = ResponseHandler.generateResponse("Image updated correctly", HttpStatus.OK, imagenService.updateImagen(imagen));
        else
            response = ResponseHandler.generateResponse("Image NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteImagen(@PathVariable Long id) throws Exception {

        ResponseEntity<Object> response;
        if (imagenService.searchImagen(id).isPresent()) {
            imagenService.deleteImagen(id);
            response = ResponseHandler.generateResponse("Image Deleted", HttpStatus.OK, null);
        }else {
            response = ResponseHandler.generateResponse("Image NOT found", HttpStatus.NOT_FOUND, null);
        }
        return response;
    }




}
