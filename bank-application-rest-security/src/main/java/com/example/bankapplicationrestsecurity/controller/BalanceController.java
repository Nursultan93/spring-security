package com.example.bankapplicationrestsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("balance")
public class BalanceController {

    @GetMapping
    public String get(){
        return "Balance";
    }
}
