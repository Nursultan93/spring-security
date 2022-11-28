package com.example.bankapplicationrestsecurity.repository;

import com.example.bankapplicationrestsecurity.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Integer> {
}
