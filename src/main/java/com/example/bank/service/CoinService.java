package com.example.bank.service;

import com.example.bank.model.Coin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CoinService {
    Coin findById(Long id);
    Coin createCoin(Coin coin);
    List<Coin> queryCoins();
    Coin updateCoin(Coin coin);
    String deleteCoin(Long id);
}
