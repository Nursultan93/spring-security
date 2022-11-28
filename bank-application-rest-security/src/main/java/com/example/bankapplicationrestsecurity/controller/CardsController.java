package com.example.bankapplicationrestsecurity.controller;

import com.example.bankapplicationrestsecurity.model.Card;
import com.example.bankapplicationrestsecurity.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardsController {

    private final CardRepository cardRepository;

    @GetMapping
    public List<Card> getAllCards(){
        return cardRepository.findAll();
    }
}
