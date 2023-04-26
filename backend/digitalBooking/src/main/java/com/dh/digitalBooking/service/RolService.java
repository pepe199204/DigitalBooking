package com.dh.digitalBooking.service;

import com.dh.digitalBooking.model.Rol;
import com.dh.digitalBooking.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    private final RolRepository rolRepository;

    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    //AGREGAR
    public Rol addRol(Rol rol){

        return rolRepository.save(rol);
    }

    //LISTAR TODAS
    public List<Rol> listRoles(){
        List<Rol> roles = rolRepository.findAll();
        return roles;
    }

    //EDITAR
    public Rol updateRol(Rol rol){
        return rolRepository.save(rol);
    }

    //BUSCAR POR ID
    public Optional<Rol> searchRol(Long id){
        return rolRepository.findById(id);
    }

    //ELIMINAR
    public void deleteRol(Long id) throws Exception{
        Optional<Rol> searchedRol = searchRol(id);
        if (searchedRol.isPresent())
            rolRepository.deleteById(id);
        else
            throw new Exception("Missing: Deleting role not found");
    }
}


