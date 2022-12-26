package com.sofka.cardService.repository;

import com.sofka.cardService.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Cars, Integer> {
    List<Cars> findByUserId(int id);

}
