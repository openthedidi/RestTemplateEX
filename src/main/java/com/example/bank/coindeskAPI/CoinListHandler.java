package com.example.bank.coindeskAPI;

import com.example.bank.model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CoinListHandler {
    @Autowired
    private Coin coin;

    @Autowired
    private BpiHandler bpiHandler;


    public Map<String,Object> transfer(BpiHandler bpi){
        CoinListHandler coinListHandler = new CoinListHandler();
        Map<String,Object> map = new HashMap<>();
        map.put(bpi.getEur().getCode(),coinListHandler.coinHandler(bpi.getEur()));
        map.put(bpi.getUsd().getCode(),coinListHandler.coinHandler(bpi.getUsd()));
        map.put(bpi.getGbp().getCode(),coinListHandler.coinHandler(bpi.getGbp()));
        return map;
    }

    public Map<String ,String> coinHandler(Coin coin){
        Map<String ,String> map= new TreeMap<>();
        if("USD".equals(coin.getCode())){
                map.put("幣別中文名稱","美金");
                map.put("幣別",coin.getCode());
        }else if("GBP".equals(coin.getCode())){
                map.put("幣別中文名稱","英鎊");
                map.put("幣別",coin.getCode());
        }else if("EUR".equals(coin.getCode())){
                map.put("幣別中文名稱","歐元");
                map.put("幣別",coin.getCode());
        }
        map.put("匯率", coin.getRate());
        return map;
    }
}
