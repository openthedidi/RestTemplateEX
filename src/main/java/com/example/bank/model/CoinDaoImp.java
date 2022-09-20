package com.example.bank.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;



@Component
public class CoinDaoImp implements CoinDao{

    @Autowired
    private CoinRepository coinRepository;


    @Override
    public Coin findById(Long id) {
        coinRepository.findById(id);
        return coinRepository.findById(id).orElse(null);
    }

    @Override
    public Coin createCoin(Coin coin) {
        Coin newCoin=coinRepository.save(coin);
        return newCoin;
    }

    @Override
    public List<Coin> queryCoins() {
         return (List<Coin>) coinRepository.findAll();
    }

    @Override
    public Coin updateCoin(Coin coin) {
        return coinRepository.save(coin);
    }

    @Override
    public String deleteCoin(Long id) {
        coinRepository.delete(coinRepository.findById(id).orElse(null));
        return "刪除成功";
    }
}
