package com.dh.digitalBooking.controller;

import com.dh.digitalBooking.dto.AuthenticationDTORequest;
import com.dh.digitalBooking.dto.AuthenticationDTOResponse;
import com.dh.digitalBooking.handler.ResponseHandler;
import com.dh.digitalBooking.model.Rol;
import com.dh.digitalBooking.model.Usuario;
import com.dh.digitalBooking.service.UsuarioService;
import com.dh.digitalBooking.service.jwt.IJwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private IJwtService iJwtService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<Object> createAuthenticationToken(@RequestBody AuthenticationDTORequest authenticationDTORequest) throws Exception{
        Authentication authentication;
        Usuario usuario = usuarioService.searchUsuarioByEmail(authenticationDTORequest.getEmail());
        // y si no encuentra al usuario por email ? validar eso
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getNombre(), authenticationDTORequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (BadCredentialsException e) {
            log.info("Error de credenciales " + e);
            return ResponseHandler.generateResponse("Credenciales inválidas", HttpStatus.UNAUTHORIZED, null);
        }


        final UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getNombre());
        final String jwt = iJwtService.generateToken(userDetails);
        final String nombreUsuario = usuarioService.nombreUsuario(usuario.getNombre());
        final String apellidoUsuario = usuarioService.apellidoUsuario(usuario.getNombre());
        final String email = usuarioService.emailUsuario(usuario.getNombre());
        final Long id = usuarioService.idUsuario(usuario.getNombre());
        final Rol rol = usuarioService.rolUsuario(usuario.getNombre());

        return ResponseHandler.generateResponse(null, HttpStatus.OK, new AuthenticationDTOResponse(jwt, nombreUsuario, apellidoUsuario, email, id, rol));
    }






//probamos si lo poniamos como no autenticado
    // SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);

    //final Rol rol = usuarioService.rolUsuario(authenticationDTORequest.getUsername());

//    @PostMapping(value = "/logOut/{token}")
//    public ResponseEntity<?> expireAuthenticationToken(@PathVariable String token) throws Exception{
////        iJwtService.expireToken(token);
////
////        ResponseEntity<Object> response = ResponseHandler.generateResponse("Se expiro el Jwt token", HttpStatus.OK, null);
////        return response;
////        Usuario userDetails =  (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        Long userId = userDetails.getId();
//        iJwtService.expireToken(token);
//        return ResponseHandler.generateResponse("Log out successful y Se expiro el Jwt token", HttpStatus.OK, null);
//    }
//    @PostMapping(value = "/logOut")
//    public ResponseEntity<?> expireToken(@RequestBody AuthenticationDTOResponse authenticationDTOResponse) throws Exception{
//        authenticationDTOResponse.getJwt();
//
//        return ResponseHandler.generateResponse("Log out successful y Se expiro el Jwt token", HttpStatus.OK, null);
//    }
    
}
