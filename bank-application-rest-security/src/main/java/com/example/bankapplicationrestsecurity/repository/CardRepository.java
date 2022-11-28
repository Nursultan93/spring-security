package com.example.bankapplicationrestsecurity.repository;

import com.example.bankapplicationrestsecurity.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
