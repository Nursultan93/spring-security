package com.example.bankapplicationrestsecurity.repository;

import com.example.bankapplicationrestsecurity.model.Balance;
import com.example.bankapplicationrestsecurity.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance, Integer> {

    //@PreAuthorize("hasRole(\"MANAGER\")")
    List<Loan> findAllById(Integer id);
}
