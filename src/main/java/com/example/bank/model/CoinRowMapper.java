package com.example.bank.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CoinRowMapper implements RowMapper<Coin> {
    @Autowired
    private Coin coin;


    @Override
    public Coin mapRow(ResultSet rs, int rowNum) throws SQLException {
        coin.setId(rs.getLong("id"));
        coin.setCode(rs.getString("code"));
        coin.setSymbol(rs.getString("symbol"));
        coin.setRate(rs.getString("rate"));
        coin.setDescription(rs.getString("description"));
        coin.setRate_float(rs.getDouble("rate_float"));
        return coin;
    }
}
