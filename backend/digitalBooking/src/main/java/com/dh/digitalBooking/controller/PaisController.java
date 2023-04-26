package com.dh.digitalBooking.controller;

import com.dh.digitalBooking.handler.ResponseHandler;
import com.dh.digitalBooking.model.Pais;
import com.dh.digitalBooking.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paises")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaisController {

    @Autowired
    private PaisService paisService;


    @PostMapping
    public ResponseEntity<Object> addPais(@RequestBody Pais pais){
        ResponseEntity<Object> response;
        if (pais.getNombre() != null)
            response = ResponseHandler.generateResponse("County added correctly", HttpStatus.OK, paisService.addPais(pais));
        else
            response = ResponseHandler.generateResponse("Country can't be added without a name", HttpStatus.INTERNAL_SERVER_ERROR,null);

        return response;
    }

    @GetMapping()
    public ResponseEntity<Object> listPaises(){
        return ResponseHandler.generateResponse("Listing all the countries...", HttpStatus.OK, paisService.listPaises());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> searchPais(@PathVariable Long id){
        ResponseEntity<Object> response;
        if (id != null && paisService.searchPais(id).isPresent())
            response = ResponseHandler.generateResponse("Country found", HttpStatus.OK, paisService.searchPais(id));
        else
            response = ResponseHandler.generateResponse("Country NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @PutMapping()
    public ResponseEntity<Object> updatePais(@RequestBody Pais pais){
        ResponseEntity<Object> response;
        if (pais.getId() != null && paisService.searchPais(pais.getId()).isPresent())
            response = ResponseHandler.generateResponse("Country updated correctly", HttpStatus.OK, paisService.updatePais(pais));
        else
            response = ResponseHandler.generateResponse("Country NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePais(@PathVariable Long id) throws Exception {

        ResponseEntity<Object> response;

        if (paisService.searchPais(id).isPresent()) {
            paisService.deletePais(id);
            response = ResponseHandler.generateResponse("Country Deleted", HttpStatus.OK, null);
        }else {
            response = ResponseHandler.generateResponse("Country NOT found", HttpStatus.NOT_FOUND, null);
        }
        return response;
    }

}
