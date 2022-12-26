package com.sofka.cardService.service.Interfaces;

import com.sofka.cardService.model.Cars;

import java.util.List;

public interface ICard {
    List<Cars> getAll();
    Cars findCard(int id);
    List<Cars> findCardUser(int id);
    Cars saveCard(Cars card);
}
