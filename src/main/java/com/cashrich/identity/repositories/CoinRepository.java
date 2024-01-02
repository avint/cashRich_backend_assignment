package com.cashrich.identity.repositories;

import com.cashrich.identity.entity.Coin;
import com.cashrich.identity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin, Integer> {
    public User findByUserId(Integer userId);

}
