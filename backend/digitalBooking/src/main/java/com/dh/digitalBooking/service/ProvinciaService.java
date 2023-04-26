package com.dh.digitalBooking.service;

import com.dh.digitalBooking.model.Pais;
import com.dh.digitalBooking.model.Provincia;
import com.dh.digitalBooking.repository.PaisRepository;
import com.dh.digitalBooking.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaService {

    private final ProvinciaRepository provinciaRepository;
    private final PaisRepository paisRepository;

    @Autowired
    public ProvinciaService(ProvinciaRepository provinciaRepository, PaisRepository paisRepository) {
        this.provinciaRepository = provinciaRepository;
        this.paisRepository = paisRepository;
    }

    //AGREGAR
    public Provincia addProvincia(Provincia provincia){
        Optional<Pais> pais = paisRepository.findById(provincia.getPais().getId());
        provincia.setPais(pais.get());
        return provinciaRepository.save(provincia);
    }

    //LISTAR TODAS
    public List<Provincia> listProvincias(){
        List<Provincia> provincias = provinciaRepository.findAll();
        return provincias;
    }

    //EDITAR
    public Provincia updateProvincias(Provincia provincia){
        Optional<Pais> pais = paisRepository.findById(provincia.getPais().getId());
        provincia.setPais(pais.get());
        return provinciaRepository.save(provincia);
    }

    //BUSCAR POR ID
    public Optional<Provincia> searchProvincia(Long id){
        return provinciaRepository.findById(id);
    }

    //ELIMINAR
    public void deleteProvincia(Long id) throws Exception{
        Optional<Provincia> searchedProvincia = searchProvincia(id);
        if (searchedProvincia.isPresent())
            provinciaRepository.deleteById(id);
        else
            throw new Exception("Missing: Deleting province not found");
    }

}
