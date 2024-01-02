package com.cashrich.identity.dao.impl;

import com.cashrich.identity.dao.UserDao;
import com.cashrich.identity.entity.User;
import com.cashrich.identity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;

    public Optional<User> getUser(Integer id){

        return userRepository.findById(id);
    }

    public User createUser(User user){
        if (user != null){
            return userRepository.save(user);
        }
        return null;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUserName(username);
    }

}
