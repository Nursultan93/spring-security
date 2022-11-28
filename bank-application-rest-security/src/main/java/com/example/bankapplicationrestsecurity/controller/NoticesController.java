package com.example.bankapplicationrestsecurity.controller;

import com.example.bankapplicationrestsecurity.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notice")
@RequiredArgsConstructor
public class NoticesController {

    @GetMapping
    public String get(){
        return "Notices";
    }
}
