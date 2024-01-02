package com.cashrich.identity.manager;

import com.cashrich.identity.dao.CoinDao;
import com.cashrich.identity.entity.Coin;
import com.cashrich.identity.entry.ResponseEntry;
import com.cashrich.identity.entry.StatusEntry;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class CoinManagerImpl implements CoinManager{

    @Autowired
    CoinDao coinDao;

    public ResponseEntry<Coin> getCoin(Integer id){
        Coin coin = coinDao.getCoin(id);
        if(coin != null){
            return convertToResponseEntry("", "200","SUCCESS", true, coin);
        }else{
            return convertToResponseEntry("Coin entry not found", "600","FAILURE", false, null);
        }
    }


    public ResponseEntry<Coin> convertToResponseEntry(String msg, String code, String status, Boolean success, Coin data){
        StatusEntry statusEntry = new StatusEntry();
        statusEntry.setCode(code);
        statusEntry.setStatus(status);
        statusEntry.setSuccess(success);
        statusEntry.setMessage(msg);
        statusEntry.setTimeStamp(LocalDateTime.now());

        ResponseEntry<Coin> response = new ResponseEntry<Coin>();
        response.setStatusEntry(statusEntry);
        response.setData(data);
        return response;
    }
}
