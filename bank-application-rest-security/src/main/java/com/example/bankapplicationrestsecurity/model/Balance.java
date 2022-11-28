package com.example.bankapplicationrestsecurity.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private BigDecimal balace;
}
