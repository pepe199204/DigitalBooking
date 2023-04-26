package com.dh.digitalBooking.controller;


import com.dh.digitalBooking.dto.ProductoDTO;
import com.dh.digitalBooking.handler.ResponseHandler;
import com.dh.digitalBooking.model.*;
import com.dh.digitalBooking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ReservaController {


    @Autowired
    public ReservaService reservaService;
    @Autowired
    public ProductoService productoService;

    @Autowired
    public UsuarioService usuarioService;

    @PostMapping(value="/newBooking")
    public ResponseEntity<Object> addReserva(@RequestBody Reserva reserva){
        ResponseEntity<Object> response;
        if(reserva.getFecha_checkin() != null)
            response =  ResponseHandler.generateResponse("Booking added correctly", HttpStatus.OK,reservaService.addReserva(reserva));
        else
            response = ResponseHandler.generateResponse("Booking can't be added with a null checkin date", HttpStatus.INTERNAL_SERVER_ERROR, null);

        return response;

    }

    @GetMapping()
    public ResponseEntity<Object> listReservas(){

        return ResponseHandler.generateResponse("Listing all the bookings...", HttpStatus.OK, reservaService.listReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> searchReservaById (@PathVariable Long id) {
        ResponseEntity<Object> response;

        Optional<Reserva> reserva = reservaService.searchReserva(id);
        if (id != null && reserva.isPresent()){
            response = ResponseHandler.generateResponse("Booking found", HttpStatus.OK, reserva);

        }
        else {
            response = ResponseHandler.generateResponse("Booking NOT found", HttpStatus.NOT_FOUND, null);

        }
        return response;
    }

    @PutMapping()
    public ResponseEntity<Object> updateReserva(@RequestBody Reserva reserva){
        ResponseEntity<Object> response;

        if (reserva.getId() != null && reservaService.searchReserva(reserva.getId()).isPresent())
            response = ResponseHandler.generateResponse("Booking updated correctly", HttpStatus.OK, reservaService.updateReserva(reserva));
        else
            response = ResponseHandler.generateResponse("Booking NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReserva(@PathVariable Long id) throws Exception {

        ResponseEntity<Object> response;

        if (reservaService.searchReserva(id).isPresent()) {
            reservaService.deleteReserva(id);
            response = ResponseHandler.generateResponse("Booking Deleted", HttpStatus.OK, null);
        }else {
            response = ResponseHandler.generateResponse("Booking NOT found", HttpStatus.NOT_FOUND, null);
        }
        return response;
    }


    @GetMapping("/ReservaByProducto/{id}")
    public ResponseEntity<Object> searchReservaByProductoId (@PathVariable Long id) {
        ResponseEntity<Object> response;
        ProductoDTO producto = productoService.searchProducto(id);
        if (id != null && producto != null){
            List<Reserva> reservas = reservaService.searchReservaByProductoId(id);
            response = ResponseHandler.generateResponse("Booking in product with id " + id + " found", HttpStatus.OK, reservas);

        }
        else {
            response = ResponseHandler.generateResponse("Booking NOT found", HttpStatus.NOT_FOUND, null);

        }
        return response;
    }

    @GetMapping("/FechasResevadasByProdctoId/{id}")
    public ResponseEntity<Object> searchFechasReservadasByProductoId (@PathVariable Long id) throws Exception {
        ResponseEntity<Object> response;
        ProductoDTO producto = productoService.searchProducto(id);
        if (id != null && producto != null){
            List<List<String>> reservas = reservaService.searchFechasReservadasByProductoId(id);
            response = ResponseHandler.generateResponse("Booked dates in product with id " + id + " found", HttpStatus.OK, reservas);

        }
        else {
            response = ResponseHandler.generateResponse("Booked dates NOT found", HttpStatus.NOT_FOUND, null);

        }
        return response;
    }

    @GetMapping("/ReservaByUsuario/{id}")
    public ResponseEntity<Object> searchReservaByUsuarioId (@PathVariable Long id) {
        ResponseEntity<Object> response;
        Optional<Usuario> usuario = usuarioService.searchUsuario(id);
        if (id != null && usuario.isPresent()){
            List<Reserva> reservas = reservaService.searchReservaByUsuarioId(id);
            response = ResponseHandler.generateResponse("Booking in User with id " + id + " found", HttpStatus.OK, reservas);

        }
        else {
            response = ResponseHandler.generateResponse("Booking NOT found", HttpStatus.NOT_FOUND, null);

        }
        return response;
    }



}
