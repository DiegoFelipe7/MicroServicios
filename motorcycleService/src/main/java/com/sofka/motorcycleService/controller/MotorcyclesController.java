package com.sofka.motorcycleService.controller;

import com.sofka.motorcycleService.model.Motorcycle;
import com.sofka.motorcycleService.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class MotorcyclesController {

    @Autowired
    private MotorcycleService motorcycleService;


    @GetMapping(value = "/motorcycles")
    public ResponseEntity<List<Motorcycle>> listMotorcycle(){
        List<Motorcycle> motorcycle = motorcycleService.getAll();
        if(motorcycle.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motorcycle);
    }

    @GetMapping(value = "/motorcycles/user/{id}")
    public ResponseEntity<List<Motorcycle>> listMotorcycleUser(@PathVariable("id") int id){
        List<Motorcycle> motorcycle = motorcycleService.findMotorcycledUser(id);
        if(motorcycle.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motorcycle);
    }


    @GetMapping(value = "/motorcycle/{id}")
    public ResponseEntity<Motorcycle> findUserId(@PathVariable("id") int id){
        Motorcycle motorcycle = motorcycleService.findMotorcycle(id);
        if(motorcycle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motorcycle);
    }

    @PostMapping(value = "/motorcycle")
    public ResponseEntity<Motorcycle> saveMotorcycle(@RequestBody Motorcycle motorcycle){
        Motorcycle motorcycle1 = motorcycleService.saveMotorcycle(motorcycle);
        return ResponseEntity.ok(motorcycle1);
    }



}
