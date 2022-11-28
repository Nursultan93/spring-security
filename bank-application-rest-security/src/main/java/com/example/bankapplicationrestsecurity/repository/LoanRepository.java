package com.example.bankapplicationrestsecurity.repository;

import com.example.bankapplicationrestsecurity.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
