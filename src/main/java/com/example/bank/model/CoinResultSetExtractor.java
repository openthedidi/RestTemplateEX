package com.example.bank.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CoinResultSetExtractor implements ResultSetExtractor<List<Coin>> {
    @Autowired
    private Coin coin;

    @Override
    public List<Coin> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<Coin> list = new ArrayList<>();
        while (rs.next()){
            coin.setId(rs.getLong("id"));
            coin.setCode(rs.getString("code"));
            coin.setSymbol(rs.getString("symbol"));
            coin.setRate(rs.getString("rate"));
            coin.setDescription(rs.getString("description"));
            coin.setRate_float(rs.getDouble("rate_float"));
            list.add(coin);
        }
        return list;
    }
}
