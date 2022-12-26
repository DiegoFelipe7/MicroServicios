package com.sofka.cardService.service;

import com.sofka.cardService.model.Cars;
import com.sofka.cardService.repository.CardRepository;
import com.sofka.cardService.service.Interfaces.ICard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService implements ICard {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Cars> getAll() {
        return cardRepository.findAll();
    }

    @Override
    public Cars findCard(int id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cars> findCardUser(int id) {
        return cardRepository.findByUserId(id);
    }

    @Override
    public Cars saveCard(Cars card) {
        return cardRepository.save(card);
    }
}
