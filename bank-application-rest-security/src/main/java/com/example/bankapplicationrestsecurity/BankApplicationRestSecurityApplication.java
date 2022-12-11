package com.example.bankapplicationrestsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class BankApplicationRestSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplicationRestSecurityApplication.class, args);
    }

}
