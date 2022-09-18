package com.example.bank.service;

import com.example.bank.model.Coin;
import com.example.bank.model.CoinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoinServiceImp implements CoinService{
    @Autowired
    private CoinDao coinDao;

    @Override
    public Coin findById(Long id) {
        return coinDao.findById(id);
    }

    @Override
    public Coin createCoin(Coin coin) {
        return coinDao.createCoin(coin);
    }

    @Override
    public List<Coin> queryCoins() {
        return coinDao.queryCoins();
    }

    @Override
    public Coin updateCoin(Coin coin) {
        return coinDao.updateCoin(coin);
    }

    @Override
    public String deleteCoin(Long id) {
        return coinDao.deleteCoin(id);
    }
}
