package com.dh.digitalBooking.controller;

import com.dh.digitalBooking.handler.ResponseHandler;
import com.dh.digitalBooking.model.Caracteristica;
import com.dh.digitalBooking.model.Producto;
import com.dh.digitalBooking.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/caracteristicas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CaracteristicaController {

    @Autowired
    private CaracteristicaService caracteristicaService;

    @PostMapping("/NewCaracteristicas")
    public ResponseEntity<Object> addCaracteristica(@RequestBody Caracteristica caracteristica){
        return ResponseHandler.generateResponse("Characteristic added correctly", HttpStatus.OK,caracteristicaService.addCaracterisitca(caracteristica));
    }

    @GetMapping()
    public ResponseEntity<Object> listCaracteristicas(){
        return ResponseHandler.generateResponse("Listing all the Characteristics...", HttpStatus.OK, caracteristicaService.listCaracteristica());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> searchCaracteristica(@PathVariable Long id){
        ResponseEntity<Object> response;
        if (id != null && caracteristicaService.searchCaracteristica(id).isPresent())
            response = ResponseHandler.generateResponse("Characteristic found", HttpStatus.OK, caracteristicaService.searchCaracteristica(id));
        else
            response = ResponseHandler.generateResponse("Characteristic NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @PutMapping()
    public ResponseEntity<Object> updateCaracteristica(@RequestBody Caracteristica caracteristica){
        ResponseEntity<Object> response;
        if (caracteristica.getId() != null && caracteristicaService.searchCaracteristica(caracteristica.getId()).isPresent())
            response = ResponseHandler.generateResponse("Characteristic updated correctly", HttpStatus.OK, caracteristicaService.updateCaracteristica(caracteristica));
        else
            response = ResponseHandler.generateResponse("Characteristic NOT found",HttpStatus.NOT_FOUND,null);

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCaracteristica(@PathVariable Long id) throws Exception {
        ResponseEntity<Object> response;
        if (caracteristicaService.searchCaracteristica(id).isPresent()) {
            caracteristicaService.deleteCaracteristica(id);
            response = ResponseHandler.generateResponse("Characteristic Deleted", HttpStatus.OK, null);
        }else {
            response = ResponseHandler.generateResponse("Characteristic NOT found", HttpStatus.NOT_FOUND, null);
        }
        return response;
    }

    @GetMapping("/Productos/{id}")
    public ResponseEntity<Object> searchProductosCaracteristica(@PathVariable Long id) throws Exception {
        ResponseEntity<Object> response = ResponseHandler.generateResponse("Products in characteristic with id: " + id + " NOT found", HttpStatus.NOT_FOUND, null);
        Optional<Caracteristica> caracteristica = caracteristicaService.searchCaracteristica(id);
        if(id !=null && caracteristica.isPresent()){
            List<Producto> productos =  caracteristicaService.searchProductosCaracteristica(id);
            if(!productos.isEmpty())
                response = ResponseHandler.generateResponse("Products in characteristic with id" + id + " found", HttpStatus.OK, productos);
        }
        return response;
    }


}
