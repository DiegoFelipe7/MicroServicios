package com.sofka.usersService.controller;

import com.sofka.usersService.model.Cars;
import com.sofka.usersService.model.Motorcycle;
import com.sofka.usersService.model.Users;
import com.sofka.usersService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<List<Users>> listUsers(){
        List<Users> users = userService.getAll();
        if(users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }
    @GetMapping(value = "/user/{id}")
    public ResponseEntity<Users> getUser(@PathVariable("id") int id){
        Users users = userService.findUser(id);
        if(users == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }


    @GetMapping(value = "/user/{id}/car")
    public ResponseEntity<List<Cars>> getUserCars(@PathVariable("id") int id){
        List<Cars> cars = userService.getCarsUser(id);
        if(cars == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cars);
    }

    @PostMapping(value = "/user/car/{id}")
    public ResponseEntity<Cars> saveCarUsers(@RequestBody Cars cars , @PathVariable("id") int id){
        Cars car = userService.saveCarro(id,cars);
        return ResponseEntity.ok(cars);
    }

    @GetMapping(value = "/user/{id}/motorcycle")
    public ResponseEntity<List<Motorcycle>> getUserMotorcycle(@PathVariable("id") int id){
        List<Motorcycle> motorcycle = userService.getCarsMotorcycle(id);
        if(motorcycle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motorcycle);
    }

    @PostMapping(value = "/user/motorcycle/{id}")
    public ResponseEntity<Motorcycle> saveCarMotorcycle(@RequestBody Motorcycle motorcycle , @PathVariable("id") int id){
        Motorcycle motorcycle1 = userService.saveMotorcycle(id,motorcycle);
        return ResponseEntity.ok(motorcycle1);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<Users> saveUsers(@RequestBody Users users){
        Users user = userService.saveUser(users);
        return ResponseEntity.ok(user);
    }

}
