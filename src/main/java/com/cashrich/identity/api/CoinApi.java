package com.cashrich.identity.api;

import com.cashrich.identity.entity.Coin;
import com.cashrich.identity.entry.ResponseEntry;
import com.cashrich.identity.entry.UserEntry;
import com.cashrich.identity.manager.CoinManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class CoinApi {
    @Autowired
    CoinManager coinManager;
    @GetMapping("api/user/{id}")
    public ResponseEntry<Coin> getCoin(@PathVariable Integer id) throws Exception {
        return coinManager.getCoin(id);
    }
}
