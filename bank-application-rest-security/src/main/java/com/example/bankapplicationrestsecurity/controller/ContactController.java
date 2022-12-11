package com.example.bankapplicationrestsecurity.controller;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contact")
public class ContactController {

    @GetMapping
    //@PreFilter("filterObject.number  != 'Test'")
    @PostFilter("filterObject.number  != 'Test'")
    public String get(){
        return "Contact";
    }
}
