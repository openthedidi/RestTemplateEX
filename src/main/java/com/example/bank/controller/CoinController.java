package com.example.bank.controller;



import com.example.bank.coindeskAPI.*;
import com.example.bank.model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.example.bank.service.CoinService;


import java.util.*;


@RestController
public class CoinController {

    @Autowired
    private CoinService coinService;
    @Autowired
    private Time time;
    @Autowired
    private CalledAPIHandler calledAPIHandler;
    @Autowired
    private CoinListHandler coinListHandler;

    @Transactional
    @PostMapping("/createCoin")
    public ResponseEntity<Coin> createCoin(@RequestBody Coin coin){
        return  ResponseEntity.status(HttpStatus.CREATED).body(coinService.createCoin(coin));
    }

    @GetMapping("/QueryCoins")
    public ResponseEntity<List<Coin>> queryCoins(){
        return ResponseEntity.status(HttpStatus.OK).body(coinService.queryCoins());
    }

    @GetMapping("/QueryCoin/{id}")
    public ResponseEntity<Coin> queryCoins(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(coinService.findById(id));
    }

    @Transactional
    @PutMapping("/updateCoin/{id}")
    public ResponseEntity<Coin> updateCoin(@RequestBody Coin coin,
                                           @PathVariable Long id){
        if(coinService.findById(id)!=null){
            coin.setId(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(coinService.updateCoin(coin));
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT    ).body(null);
        }
    }

    @Transactional
    @DeleteMapping("/deleteCoin/{id}")
    public ResponseEntity<?> deleteCoin(@PathVariable Long id){
        if(coinService.findById(id)!=null){
            coinService.deleteCoin(id);
            return ResponseEntity.status(204).body(null);
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }



    @GetMapping("/CallCoindeskAPI")
    public ResponseEntity<Map<String,Object>> CallCoindesk() {
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        time = calledAPIHandler.handler(url).getTime();
        Map<String,Object> result = new HashMap<>();

        Map<String,Object> timeResult = new TreeMap<>();
        timeResult.put("updated",time.updatedTimeTransfer(time.getUpdated()));
        timeResult.put("updatedISO",time.updatedISOTimeTransfer(time.getUpdatedISO()));
        timeResult.put("updateduk",time.updatedukTimeTransfer(time.getUpdateduk()));
        result.put("time",timeResult);

        BpiHandler bpi = calledAPIHandler.handler(url).getBpi();
        result.put("bpi",coinListHandler.transfer(bpi));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
