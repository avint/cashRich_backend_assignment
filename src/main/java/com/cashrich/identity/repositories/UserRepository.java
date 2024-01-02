package com.cashrich.identity.repositories;

import com.cashrich.identity.entity.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUserName(String userName);
}
