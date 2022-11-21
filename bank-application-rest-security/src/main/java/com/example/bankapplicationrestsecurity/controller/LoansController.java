package com.example.bankapplicationrestsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("loan")
public class LoansController {

    @GetMapping
    public String get(){
        return "Loans";
    }
}
