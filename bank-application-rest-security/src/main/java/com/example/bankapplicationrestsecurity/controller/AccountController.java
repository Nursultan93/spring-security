package com.example.bankapplicationrestsecurity.controller;

import com.example.bankapplicationrestsecurity.model.Customer;
import com.example.bankapplicationrestsecurity.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {

    private CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<List<Customer>> get(){
        return ResponseEntity.ok().body(customerRepository.findAll());
    }
}
