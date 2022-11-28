package com.example.bankapplicationrestsecurity.repository;

import com.example.bankapplicationrestsecurity.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConectRepository extends JpaRepository<Contact, Integer> {
}
