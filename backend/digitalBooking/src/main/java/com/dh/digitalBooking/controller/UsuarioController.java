package com.dh.digitalBooking.controller;
import com.dh.digitalBooking.handler.ResponseHandler;
import com.dh.digitalBooking.model.Usuario;
import com.dh.digitalBooking.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Object> addUsuario(@RequestBody Usuario usuario){
        ResponseEntity<Object> response;
        if (usuario.getNombre() != null)
            response = ResponseHandler.generateResponse("User added correctly", HttpStatus.CREATED, usuarioService.addusuario(usuario));
        else
            response = ResponseHandler.generateResponse("User can't be added without a name", HttpStatus.INTERNAL_SERVER_ERROR,null);

        return response;
    }

    @GetMapping()
    public ResponseEntity<Object> listUsuarios(){
        return ResponseHandler.generateResponse("Listing all the users...", HttpStatus.OK, usuarioService.listUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> searchUsuario(@PathVariable Long id){
        ResponseEntity<Object> response;

        if (id != null && usuarioService.searchUsuario(id).isPresent())
            response = ResponseHandler.generateResponse("User found", HttpStatus.OK, usuarioService.searchUsuario(id));
        else
            response = ResponseHandler.generateResponse("User NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @PutMapping()
    public ResponseEntity<Object> updateUsuario(@RequestBody Usuario usuario){
        ResponseEntity<Object> response;

        if (usuario.getId() != null && usuarioService.searchUsuario(usuario.getId()).isPresent())
            response = ResponseHandler.generateResponse("User updated correctly", HttpStatus.OK, usuarioService.updateUsuarios(usuario));
        else
            response = ResponseHandler.generateResponse("User NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable Long id) throws Exception {

        ResponseEntity<Object> response;
        if (usuarioService.searchUsuario(id).isPresent()) {
            usuarioService.deleteUsuario(id);
            response = ResponseHandler.generateResponse("User Deleted", HttpStatus.OK, null);
        }else {
            response = ResponseHandler.generateResponse("User NOT found", HttpStatus.NOT_FOUND, null);
        }
        return response;
    }


}
