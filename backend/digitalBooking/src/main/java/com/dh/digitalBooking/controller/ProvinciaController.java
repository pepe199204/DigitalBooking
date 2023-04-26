package com.dh.digitalBooking.controller;


import com.dh.digitalBooking.handler.ResponseHandler;
import com.dh.digitalBooking.model.Provincia;
import com.dh.digitalBooking.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provincias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    @PostMapping
    public ResponseEntity<Object> addProvincia(@RequestBody Provincia provincia){
        ResponseEntity<Object> response;
        if (provincia.getNombre() != null)
            response = ResponseHandler.generateResponse("Province added correctly", HttpStatus.OK,provinciaService.addProvincia(provincia));
        else
            response = ResponseHandler.generateResponse("Province can't be added without a name", HttpStatus.INTERNAL_SERVER_ERROR,null);

        return response;
    }

    @GetMapping()
    public ResponseEntity<Object> listProvincias(){
        return ResponseHandler.generateResponse("Listing all the provinces...", HttpStatus.OK, provinciaService.listProvincias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> searchProvincia(@PathVariable Long id){
        ResponseEntity<Object> response;

        if (id != null && provinciaService.searchProvincia(id).isPresent())
            response = ResponseHandler.generateResponse("Province found", HttpStatus.OK, provinciaService.searchProvincia(id));
        else
            response = ResponseHandler.generateResponse("Province NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @PutMapping()
    public ResponseEntity<Object> updateProvincia(@RequestBody Provincia provincia){
        ResponseEntity<Object> response;

        if (provincia.getId() != null && provinciaService.searchProvincia(provincia.getId()).isPresent())
            response = ResponseHandler.generateResponse("Province updated correctly", HttpStatus.OK, provinciaService.updateProvincias(provincia));
        else
            response = ResponseHandler.generateResponse("Province NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProvincia(@PathVariable Long id) throws Exception {

        ResponseEntity<Object> response;

        if (provinciaService.searchProvincia(id).isPresent()) {
            provinciaService.deleteProvincia(id);
            response = ResponseHandler.generateResponse("Province Deleted", HttpStatus.OK, null);
        }else {
            response = ResponseHandler.generateResponse("Province NOT found", HttpStatus.NOT_FOUND, null);
        }
        return response;
    }


}
