package com.example.bankapplicationrestsecurity.service;

import com.example.bankapplicationrestsecurity.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class CustomerDetailService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        var customer = customerRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(email + " not found"));

        return new User(customer.getEmail(), customer.getPassword(), Set.of(new SimpleGrantedAuthority(customer.getRole())));
    }
}
