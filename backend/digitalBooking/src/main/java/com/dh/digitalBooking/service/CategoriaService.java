package com.dh.digitalBooking.service;

import com.dh.digitalBooking.model.Categoria;
import com.dh.digitalBooking.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    //AGREGAR
    public Categoria addCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    //LISTAR TODAS
    public List<Categoria> listCategorias(){
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias;
    }

    //EDITAR
    public Categoria updateCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    //BUSCAR POR ID
    public Optional<Categoria> searchCategoria(Long id){
        return categoriaRepository.findById(id);
    }

    //ELIMINAR
    public void deleteCategoria(Long id) throws Exception{
        Optional<Categoria> searchedCategoria = searchCategoria(id);
        if (searchedCategoria.isPresent())
            categoriaRepository.deleteById(id);
        else
            throw new Exception("Missing: Deleting category not found");
    }

}
