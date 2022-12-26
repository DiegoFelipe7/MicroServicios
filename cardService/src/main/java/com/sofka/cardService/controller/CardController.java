package com.sofka.cardService.controller;

import com.sofka.cardService.model.Cars;
import com.sofka.cardService.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")

public class CardController {


    @Autowired
    private CardService cardService;


    @GetMapping(value = "/cars")
    public ResponseEntity<List<Cars>> listCars(){
        List<Cars> carros = cardService.getAll();
        if(carros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }


    @GetMapping(value = "/cars/user/{id}")
    public ResponseEntity<List<Cars>> listCarsUser(@PathVariable("id") int id){
        System.out.println(id);
        List<Cars> carros = cardService.findCardUser(id);
        if(carros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

    @GetMapping(value = "/car/{id}")
    public ResponseEntity<Cars> getCar(@PathVariable("id") int id){
        Cars carro = cardService.findCard(id);
        if(carro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }


    @PostMapping(value = "/car")
    public ResponseEntity<Cars> guardarCarro(@RequestBody Cars carro){
        Cars nuevoCarro = cardService.saveCard(carro);
        return ResponseEntity.ok(nuevoCarro);
    }


}
