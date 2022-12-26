package com.sofka.motorcycleService.service;

import com.sofka.motorcycleService.model.Motorcycle;
import com.sofka.motorcycleService.repository.MotorcycleRepository;
import com.sofka.motorcycleService.service.Interfaces.IMotorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MotorcycleService implements IMotorcycle {
    @Autowired
    private MotorcycleRepository motorcycleRepository;

    @Override
    public List<Motorcycle> getAll() {
        return motorcycleRepository.findAll();
    }

    @Override
    public Motorcycle findMotorcycle(int id) {
        return motorcycleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Motorcycle> findMotorcycledUser(int id) {
        return motorcycleRepository.findByUserId(id);
    }

    @Override
    public Motorcycle saveMotorcycle(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }
}
