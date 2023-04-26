package com.dh.digitalBooking.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dh.digitalBooking.model.Reserva;
import com.dh.digitalBooking.repository.ReservaRepository;
import com.dh.digitalBooking.model.Producto;
import com.dh.digitalBooking.repository.ProductoRepository;
import com.dh.digitalBooking.model.Usuario;
import com.dh.digitalBooking.repository.UsuarioRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;


    @Autowired
    public ReservaService(ReservaRepository reservaRepository, ProductoRepository productoRepository, UsuarioRepository usuarioRepository) {
        this.reservaRepository = reservaRepository;
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;

    }

    //AGREGAR
    public Reserva addReserva(Reserva reserva){
        Optional<Producto> producto = productoRepository.findById(reserva.getProducto().getId());
        reserva.setProducto(producto.get());
        Optional<Usuario> usuario = usuarioRepository.findById(reserva.getUsuario().getId());
        reserva.setUsuario(usuario.get());
        return reservaRepository.save(reserva);
    }

    //LISTAR TODAS
    public List<Reserva> listReservas(){
        List<Reserva> reservas = reservaRepository.findAll();
        return reservas;
    }

    //EDITAR
    public Reserva updateReserva(Reserva reserva){
        Optional<Producto> producto = productoRepository.findById(reserva.getProducto().getId());
        reserva.setProducto(producto.get());
        Optional<Usuario> usuario = usuarioRepository.findById(reserva.getUsuario().getId());
        reserva.setUsuario(usuario.get());
        return reservaRepository.save(reserva);
    }

    //BUSCAR POR ID
    public Optional<Reserva> searchReserva(Long id){
        return reservaRepository.findById(id);
    }

    //ELIMINAR
    public void deleteReserva(Long id) throws Exception{
        Optional<Reserva> searchedReserva = searchReserva(id);
        if (searchedReserva.isPresent())
            reservaRepository.deleteById(id);
        else
            throw new Exception("Missing: Deleting booking not found");
    }

    //BUSCAR POR PRODUCTO ID
    public List<Reserva> searchReservaByProductoId(Long id) {
        return reservaRepository.findByProductoId(id);
    }

    //BUSCAR POR FECHAS
    public  List<List<String>> searchFechasReservadasByProductoId(Long id) throws Exception{
        List<List<String>> resultado = reservaRepository.searchFechasReservadas(id);
        if(resultado == null) throw new Exception("No products available in date range.");
        else return  resultado;
    }

    //BUSCAR POR PRODUCTO ID
    public List<Reserva> searchReservaByUsuarioId(Long id) {
        return reservaRepository.findByUsuarioId(id);
    }

}
