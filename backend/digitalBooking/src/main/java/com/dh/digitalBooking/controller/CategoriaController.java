package com.dh.digitalBooking.controller;


import com.dh.digitalBooking.handler.ResponseHandler;
import com.dh.digitalBooking.model.Categoria;
import com.dh.digitalBooking.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Object> addCategoria(@RequestBody Categoria categoria){
        return ResponseHandler.generateResponse("Category added correctly",HttpStatus.OK,categoriaService.addCategoria(categoria));
    }

    @GetMapping()
    public ResponseEntity<Object> listCategorias(){
        return ResponseHandler.generateResponse("Listing all the categories...", HttpStatus.OK, categoriaService.listCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> searchCategoria (@PathVariable Long id){
        ResponseEntity<Object> response;

        if (id != null && categoriaService.searchCategoria(id).isPresent())
            response = ResponseHandler.generateResponse("Category found", HttpStatus.OK, categoriaService.searchCategoria(id));
        else
            response = ResponseHandler.generateResponse("Category NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @PutMapping()
    public ResponseEntity<Object> updateCategoria(@RequestBody Categoria categoria){
        ResponseEntity<Object> response;

        if (categoria.getId() != null && categoriaService.searchCategoria(categoria.getId()).isPresent())
            response = ResponseHandler.generateResponse("Category updated correctly", HttpStatus.OK, categoriaService.updateCategoria(categoria));
        else
            response = ResponseHandler.generateResponse("Category NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCatgoria(@PathVariable Long id) throws Exception {

        ResponseEntity<Object> response;

        if (categoriaService.searchCategoria(id).isPresent()) {

            categoriaService.deleteCategoria(id);
            response = ResponseHandler.generateResponse("Category Deleted", HttpStatus.OK, null);

        }else {
            response = ResponseHandler.generateResponse("Category NOT found", HttpStatus.NOT_FOUND, null);
        }
        return response;
    }

}

 