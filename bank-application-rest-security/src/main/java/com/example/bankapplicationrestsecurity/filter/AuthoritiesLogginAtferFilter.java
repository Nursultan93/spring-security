package com.example.bankapplicationrestsecurity.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Objects;

@Slf4j
public class AuthoritiesLogginAtferFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.nonNull(authentication)){
            log.info("User " + authentication.getName() + " is succesfuly autenticated has the authorities " +
                    authentication.getAuthorities().toString());
        }

        chain.doFilter(request, response);
    }
}
