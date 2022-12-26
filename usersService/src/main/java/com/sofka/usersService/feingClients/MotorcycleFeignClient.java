package com.sofka.usersService.feingClients;

import com.sofka.usersService.model.Motorcycle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "motorcycleService" , url = "http://localhost:8083")
@RequestMapping("/api")
public interface MotorcycleFeignClient {
    @PostMapping("/motorcycle")
    Motorcycle save(@RequestBody Motorcycle motorcycle);
    @GetMapping("/motorcycles/user/{id}")
    List<Motorcycle> getAllMotorcycle(@PathVariable("id") int id);
}
