package com.sofka.usersService.feingClients;

import com.sofka.usersService.model.Cars;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "cardService" ,url = "http://localhost:8082")
@RequestMapping("/api")
public interface CarFeignClient {
    @PostMapping("/car")
     Cars save(@RequestBody Cars cars);
    @GetMapping("/cars/user/{id}")
    List<Cars> getAllCar(@PathVariable("id") int id);
}
