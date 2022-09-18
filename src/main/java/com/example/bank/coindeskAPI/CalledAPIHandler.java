package com.example.bank.coindeskAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalledAPIHandler {
    @Autowired
    private RestTemplateUtil restTemplateUtil;


    public ResultAPI handler(String url){
        ResultAPI resultAPI = restTemplateUtil.getInstance().getForObject(url,ResultAPI.class);
        return  resultAPI;
    }
}
