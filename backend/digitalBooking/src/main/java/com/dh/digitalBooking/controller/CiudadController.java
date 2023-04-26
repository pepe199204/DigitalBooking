package com.dh.digitalBooking.controller;

import com.dh.digitalBooking.handler.ResponseHandler;
import com.dh.digitalBooking.model.Ciudad;
import com.dh.digitalBooking.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ciudades")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @PostMapping
    public ResponseEntity<Object> addCiudad(@RequestBody Ciudad ciudad){
        ResponseEntity<Object> response;
        if (ciudad.getNombre() != null)
            response = ResponseHandler.generateResponse("City added correctly", HttpStatus.OK, ciudadService.addCiudad(ciudad));
        else
            response = ResponseHandler.generateResponse("City can't be added without a name", HttpStatus.INTERNAL_SERVER_ERROR,null);

        return response;
    }

    @GetMapping()
    public ResponseEntity<Object> listCiudades(){
        return ResponseHandler.generateResponse("Listing all the cities...", HttpStatus.OK, ciudadService.listCiudades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> searchCiudad(@PathVariable Long id){
        ResponseEntity<Object> response;

        if (id != null && ciudadService.searchCiudad(id).isPresent())
            response = ResponseHandler.generateResponse("City found", HttpStatus.OK, ciudadService.searchCiudad(id));
        else
            response = ResponseHandler.generateResponse("City NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @PutMapping()
    public ResponseEntity<Object> updateCiudad(@RequestBody Ciudad ciudad){
        ResponseEntity<Object> response;

        if (ciudad.getId() != null && ciudadService.searchCiudad(ciudad.getId()).isPresent())
            response = ResponseHandler.generateResponse("City updated correctly", HttpStatus.OK, ciudadService.updateCiudad(ciudad));
        else
            response = ResponseHandler.generateResponse("City NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCiudad(@PathVariable Long id) throws Exception {

        ResponseEntity<Object> response;
        if (ciudadService.searchCiudad(id).isPresent()) {
            ciudadService.deleteCiudad(id);
            response = ResponseHandler.generateResponse("City Deleted", HttpStatus.OK, null);
        }else {
            response = ResponseHandler.generateResponse("City NOT found", HttpStatus.NOT_FOUND, null);
        }
        return response;
    }

}
