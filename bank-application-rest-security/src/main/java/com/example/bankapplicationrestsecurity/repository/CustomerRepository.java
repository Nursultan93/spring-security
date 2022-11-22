package com.example.bankapplicationrestsecurity.repository;

import com.example.bankapplicationrestsecurity.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);
}
