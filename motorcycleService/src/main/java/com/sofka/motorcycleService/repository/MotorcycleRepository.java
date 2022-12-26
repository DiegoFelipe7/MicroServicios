package com.sofka.motorcycleService.repository;

import com.sofka.motorcycleService.model.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle , Integer> {

    List<Motorcycle> findByUserId(int id);
}
