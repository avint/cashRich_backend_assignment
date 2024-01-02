package com.cashrich.identity.manager;

import com.cashrich.identity.entity.Coin;
import com.cashrich.identity.entry.ResponseEntry;

public interface CoinManager {

    public ResponseEntry<Coin> getCoin(Integer id);
}
