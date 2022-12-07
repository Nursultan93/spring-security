package com.example.bankapplicationrestsecurity.config;

import com.example.bankapplicationrestsecurity.model.Autority;
import com.example.bankapplicationrestsecurity.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class BankAuthenticationProvider implements AuthenticationProvider {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        var customer = customerRepository.findByEmail(username).get();
        if (Objects.nonNull(customer)){
            if (passwordEncoder.matches(password, customer.getPassword())){
                return new UsernamePasswordAuthenticationToken(username, password, getAutorities(customer.getAutorities()));
            }else {
                throw new BadCredentialsException("Invalid password");
            }
        }else {
            throw new BadCredentialsException("No register with this details");
        }
    }

    private List<GrantedAuthority> getAutorities(Set<Autority> autorities) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (Autority autority : autorities) {
            authorityList.add(new SimpleGrantedAuthority(autority.getName()));
        }
        return authorityList;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
