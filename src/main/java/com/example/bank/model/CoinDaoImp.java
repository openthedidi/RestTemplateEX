package com.example.bank.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class CoinDaoImp implements CoinDao{
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private CoinRepository coinRepository;


    @Override
    public Coin findById(Long id) {
        coinRepository.findById(id);
        return coinRepository.findById(id).orElse(null);
    }

    @Override
    public Coin createCoin(Coin coin) {
        final String sql = "insert into coin (code,symbol,rate,description,rate_float) values (:code,:symbol,:rate,:description,:rate_float)";
        Map<String,Object> map = new HashMap<>();
        map.put("code",coin.getCode());
        map.put("symbol",coin.getSymbol());
        map.put("rate",coin.getRate());
        map.put("description",coin.getDescription());
        map.put("rate_float",coin.getRate_float());
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
