package com.cashrich.identity.dao;

import com.cashrich.identity.entity.Coin;

public interface CoinDao{

    public Coin getCoin(Integer id);
    public Coin createCoin(Coin coin);
}
