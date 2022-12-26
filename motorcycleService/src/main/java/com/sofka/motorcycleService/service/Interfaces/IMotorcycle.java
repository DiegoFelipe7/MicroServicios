package com.sofka.motorcycleService.service.Interfaces;

import com.sofka.motorcycleService.model.Motorcycle;

import java.util.List;

public interface IMotorcycle {
    List<Motorcycle> getAll();
    Motorcycle findMotorcycle(int id);
    List<Motorcycle> findMotorcycledUser(int id);
    Motorcycle saveMotorcycle(Motorcycle motorcycle);
}
