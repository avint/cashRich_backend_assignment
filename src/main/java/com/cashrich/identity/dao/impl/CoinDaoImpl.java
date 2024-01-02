package com.cashrich.identity.dao.impl;

import com.cashrich.identity.dao.CoinDao;
import com.cashrich.identity.entity.Coin;
import com.cashrich.identity.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CoinDaoImpl implements CoinDao {
    @Autowired
    CoinRepository coinRepository;
    public Coin getCoin(Integer id){
        if(coinRepository.findById(id).isEmpty()){
            return null;
        }
        return coinRepository.findById(id).get();
    }
    public Coin createCoin(Coin coin){
        if (coin != null){
            return coinRepository.save(coin);
        }
        return null;
    }

}
