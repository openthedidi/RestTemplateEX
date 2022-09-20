package com.example.bank.coindeskAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.jupiter.api.Assertions.*;

class CalledAPIHandlerTest {


    @Test
    void handler() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplateUtil restTemplateUtil = new RestTemplateUtil();
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        ResultAPI resultAPI =restTemplateUtil.getInstance().getForObject(url,ResultAPI.class);
        String json = objectMapper.writeValueAsString(resultAPI);
        System.out.println(json);
        assertNotNull(resultAPI);
        assertThat(resultAPI.getTime(), instanceOf(Time.class));
        assertThat(resultAPI.getBpi(), instanceOf(BpiHandler.class));
        assertEquals("USD",resultAPI.getBpi().getUsd().getCode());

    }
}