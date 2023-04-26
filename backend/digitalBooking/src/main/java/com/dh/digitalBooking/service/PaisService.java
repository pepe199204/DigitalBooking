package com.dh.digitalBooking.service;

import com.dh.digitalBooking.model.Pais;
import com.dh.digitalBooking.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {
    private final PaisRepository paisRepository;

    @Autowired
    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    //AGREGAR
    public Pais addPais(Pais pais){

        return paisRepository.save(pais);
    }

    //LISTAR TODAS
    public List<Pais> listPaises(){
        List<Pais> paises = paisRepository.findAll();
        return paises;
    }

    //EDITAR
    public Pais updatePais(Pais pais){
        return paisRepository.save(pais);
    }

    //BUSCAR POR ID
    public Optional<Pais> searchPais(Long id){
        return paisRepository.findById(id);
    }

    //ELIMINAR
    public void deletePais(Long id) throws Exception{
        Optional<Pais> searchedPais = searchPais(id);
        if (searchedPais.isPresent())
            paisRepository.deleteById(id);
        else
            throw new Exception("Missing: Deleting country not found");
    }
}
