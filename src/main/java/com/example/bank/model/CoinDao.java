package com.example.bank.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CoinDao {
    Coin findById(Long id);
    Coin createCoin(Coin coin);
    List<Coin> queryCoins();
    Coin updateCoin(Coin coin);
    String deleteCoin(Long id);
}
