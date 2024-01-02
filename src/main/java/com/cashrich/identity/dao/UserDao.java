package com.cashrich.identity.dao;

import com.cashrich.identity.entity.User;

import java.util.Optional;

public interface UserDao {

    public Optional<User> getUser(Integer id);
    public User createUser(User user);

    public User getUserByUsername(String username);
}
