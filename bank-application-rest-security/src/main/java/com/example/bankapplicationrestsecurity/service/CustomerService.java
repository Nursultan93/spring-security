package com.example.bankapplicationrestsecurity.service;

import com.example.bankapplicationrestsecurity.model.Customer;
import com.example.bankapplicationrestsecurity.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }
}
