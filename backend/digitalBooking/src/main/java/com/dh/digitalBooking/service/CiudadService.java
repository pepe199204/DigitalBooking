package com.dh.digitalBooking.service;

import com.dh.digitalBooking.model.Ciudad;
import com.dh.digitalBooking.model.Pais;
import com.dh.digitalBooking.model.Provincia;
import com.dh.digitalBooking.repository.CiudadRepository;
import com.dh.digitalBooking.repository.PaisRepository;
import com.dh.digitalBooking.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CiudadService {
    private final CiudadRepository ciudadRepository;
    private final ProvinciaRepository provinciaRepository;

    @Autowired
    public CiudadService(CiudadRepository ciudadRepository, ProvinciaRepository provinciaRepository, PaisRepository paisRepository) {
        this.ciudadRepository = ciudadRepository;
        this.provinciaRepository = provinciaRepository;
    }

    //AGREGAR
    public Ciudad addCiudad(Ciudad ciudad){
        Optional<Provincia> provincia = provinciaRepository.findById(ciudad.getProvincia().getId());
        ciudad.setProvincia(provincia.get());
        return ciudadRepository.save(ciudad);
    }

    //LISTAR TODAS
    public List<Ciudad> listCiudades(){
        List<Ciudad> ciudades = ciudadRepository.findAll();
        return ciudades;
    }

    //EDITAR
    public Ciudad updateCiudad(Ciudad ciudad){
        return ciudadRepository.save(ciudad);
    }

    //BUSCAR POR ID
    public Optional<Ciudad> searchCiudad(Long id){
        return ciudadRepository.findById(id);
    }

    //ELIMINAR
    public void deleteCiudad(Long id) throws Exception{
        Optional<Ciudad> searchedCiudad = searchCiudad(id);
        if (searchedCiudad.isPresent())
            ciudadRepository.deleteById(id);
        else
            throw new Exception("Missing: Deleting city not found");
    }


}
