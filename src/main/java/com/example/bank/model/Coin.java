package com.example.bank.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class Coin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String code;
    private String symbol;
    private String rate;
    private String description;
    public double rate_float;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRate_float() {
        return rate_float;
    }

    public void setRate_float(double rate_float) {
        this.rate_float = rate_float;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

}
