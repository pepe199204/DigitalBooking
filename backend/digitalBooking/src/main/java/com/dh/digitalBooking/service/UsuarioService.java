package com.dh.digitalBooking.service;

import com.dh.digitalBooking.model.Rol;
import com.dh.digitalBooking.model.Usuario;
import com.dh.digitalBooking.repository.RolRepository;
import com.dh.digitalBooking.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository){
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    public Usuario addusuario(Usuario usuario) //throws EmailExistsException
    {
        /*if (emailExist(usuario.getEmail())) {
            throw new EmailExistsException(
                    "Ya existe una cuenta con el email ingresado:" + usuario.getEmail());
        }*/
        Rol rol = rolRepository.findByNombre("User");
        usuario.setRol(rol);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    //LISTAR TODAS
    public List<Usuario> listUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    //EDITAR
    public Usuario updateUsuarios(Usuario usuario){
        Optional<Rol> rol = rolRepository.findById(usuario.getRol().getId());
        usuario.setRol(rol.get());
        return usuarioRepository.save(usuario);
    }

    //BUSCAR POR ID
    public Optional<Usuario> searchUsuario(Long id){
        return usuarioRepository.findById(id);
    }

    //ELIMINAR
    public void deleteUsuario(Long id) throws Exception{
        Optional<Usuario> searchedUsuario = searchUsuario(id);
        if (searchedUsuario.isPresent())
            usuarioRepository.deleteById(id);
        else
            throw new Exception("Missing: Deleting user not found");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Consultara username " + username + " en base de datos");
        Usuario usuario = usuarioRepository.findByNombre(username);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(usuario.getRol().getNombre()));
        String nombre = usuario.getNombre();
        log.info("Usuario autenticado: " + username);
        return new User(nombre, usuario.getPassword(), true, true, true, true, authorities);
    }

    public Long idUsuario(String username){
        Usuario usuario = usuarioRepository.findByNombre(username);
        Long id = usuario.getId();
        return id;
    }

    public String nombreUsuario(String username){
        Usuario usuario = usuarioRepository.findByNombre(username);
        String nombre = usuario.getNombre();
        return nombre;
    }

    public String apellidoUsuario(String username){
        Usuario usuario= usuarioRepository.findByNombre(username);
        String apellido = usuario.getApellido();
        return apellido;
    }

    public String emailUsuario(String username){
        Usuario usuario= usuarioRepository.findByNombre(username);
        String email = usuario.getEmail();
        return email;
    }

    public Rol rolUsuario(String username){
        Usuario usuario= usuarioRepository.findByNombre(username);
        Rol rol = usuario.getRol();
        return rol;
    }

    public Usuario searchUsuarioByEmail(String email){
        Usuario usuario= usuarioRepository.findByEmail(email);
        return usuario;
    }


}
