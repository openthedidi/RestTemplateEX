package com.example.bank.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CoinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Transactional
    @Test
    void createCoin() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/createCoin")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"code\": \"UAD\",\n" +
                        "\"symbol\": \"&#36;\",\n" +
                        "\"rate\": \"21,606.37668\",\n" +
                        "\"description\": \"United States Dollar\",\n" +
                        "\"rate_float\": 21606.3766\n" +
                        "}");
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(201))
                .andExpect(jsonPath("$.code",equalTo("UAD")))
                .andExpect(jsonPath("$.id",equalTo(2)));
    }

    @Test
    void queryCoins() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/QueryCoins");
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].code",equalTo("USD")))
                .andReturn();
    }

    @Transactional
    @Test
    void updateCoin() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/updateCoin/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"code\": \"UAB\",\n" +
                        "\"symbol\": \"&#36;\",\n" +
                        "\"rate\": \"21,606.37668\",\n" +
                        "\"description\": \"United States Dollar\",\n" +
                        "\"rate_float\": 21606.3766\n" +
                        "}");
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(201))
                .andExpect(jsonPath("$.code",equalTo("UAB")))
                .andReturn();
    }

    @Transactional
    @Test
    void deleteCoin() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/deleteCoin/{id}",1);
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(204))
                .andReturn();
    }

    @Test
    void callCoindesk() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/CallCoindeskAPI");
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.bpi.EUR.幣別",equalTo("EUR")))
                .andReturn();
    }
}