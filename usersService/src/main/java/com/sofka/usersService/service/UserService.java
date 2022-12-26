package com.sofka.usersService.service;

import com.sofka.usersService.feingClients.CarFeignClient;
import com.sofka.usersService.feingClients.MotorcycleFeignClient;
import com.sofka.usersService.model.Cars;
import com.sofka.usersService.model.Motorcycle;
import com.sofka.usersService.model.Users;
import com.sofka.usersService.repository.UserRepository;
import com.sofka.usersService.service.interfaces.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUser {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    CarFeignClient carFeignClient;
    @Autowired
    MotorcycleFeignClient motorcycleFeignClient;

    public Cars saveCarro(int userId, Cars cars){
        cars.setUserId(userId);
        return carFeignClient.save(cars);
    }

    public List<Cars> getCarsUser(int id){
        return carFeignClient.getAllCar(id);
    }

    public Motorcycle saveMotorcycle(int userId, Motorcycle motorcycle){
        motorcycle.setUserId(userId);
        return motorcycleFeignClient.save(motorcycle);
    }

    public List<Motorcycle> getCarsMotorcycle(int id){
        return motorcycleFeignClient.getAllMotorcycle(id);
    }


    @Override
    public List<Users> getAll() {
        return userRepository.findAll();
    }
    @Override
    public Users findUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }
}
