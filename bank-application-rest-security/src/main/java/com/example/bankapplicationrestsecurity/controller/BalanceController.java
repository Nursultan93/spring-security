package com.example.bankapplicationrestsecurity.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("balance")
public class BalanceController {

    @GetMapping
    @PostAuthorize("hasRole(\"MANAGER\")")
    public String get(){
        return "Balance";
    }
}
