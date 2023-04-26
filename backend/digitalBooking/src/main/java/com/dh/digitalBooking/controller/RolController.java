package com.dh.digitalBooking.controller;

import com.dh.digitalBooking.handler.ResponseHandler;
import com.dh.digitalBooking.model.Rol;
import com.dh.digitalBooking.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class RolController {

    @Autowired
    private RolService rolService;


    @PostMapping
    public ResponseEntity<Object> addRol(@RequestBody Rol rol){
        ResponseEntity<Object> response;
        if (rol.getNombre() != null)
            response = ResponseHandler.generateResponse("Role added correctly", HttpStatus.OK, rolService.addRol(rol));
        else
            response = ResponseHandler.generateResponse("Role can't be added without a name", HttpStatus.INTERNAL_SERVER_ERROR,null);

        return response;
    }

    @GetMapping()
    public ResponseEntity<Object> listRoles(){
        return ResponseHandler.generateResponse("Listing all the roles...", HttpStatus.OK, rolService.listRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> searchRol(@PathVariable Long id){
        ResponseEntity<Object> response;
        if (id != null && rolService.searchRol(id).isPresent())
            response = ResponseHandler.generateResponse("Role found", HttpStatus.OK, rolService.searchRol(id));
        else
            response = ResponseHandler.generateResponse("Role NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @PutMapping()
    public ResponseEntity<Object> updateRol(@RequestBody Rol rol){
        ResponseEntity<Object> response;
        if (rol.getId() != null && rolService.searchRol(rol.getId()).isPresent())
            response = ResponseHandler.generateResponse("Role updated correctly", HttpStatus.OK, rolService.updateRol(rol));
        else
            response = ResponseHandler.generateResponse("Role NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRol(@PathVariable Long id) throws Exception {

        ResponseEntity<Object> response;

        if (rolService.searchRol(id).isPresent()) {
            rolService.deleteRol(id);
            response = ResponseHandler.generateResponse("Role Deleted", HttpStatus.OK, null);
        }else {
            response = ResponseHandler.generateResponse("Role NOT found", HttpStatus.NOT_FOUND, null);
        }
        return response;
    }

}
