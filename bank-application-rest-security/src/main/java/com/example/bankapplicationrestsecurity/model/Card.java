package com.example.bankapplicationrestsecurity.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String pan;
    private String expDate;
    private int pin;
}
