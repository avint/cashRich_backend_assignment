package com.cashrich.identity.utils;


import com.cashrich.identity.entity.User;
import com.cashrich.identity.entry.UserEntry;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class TransformUtil {

    public UserEntry entityToEntry(Optional<User> userOptional){
        UserEntry userEntry = new UserEntry();

        if(userOptional.isEmpty()){
            return userEntry;
        }
        User user = userOptional.get();
        if(user.getId() != null){
            userEntry.setId(user.getId());
        }
        if(user.getUserName() != null){
            userEntry.setUserName(user.getUserName());
        }
        if(user.getEmailId() != null){
            userEntry.setEmailId(user.getEmailId());
        }
        return userEntry;
    }

    public User entryToEntity(UserEntry entry, User user){

        if (user == null){
            user = new User();
        }
        if(entry.getId() != null){
            user.setId(entry.getId());
        }
        if(entry.getUserName() != null){
            user.setUserName(entry.getUserName());
        }
        if(entry.getFirstName() != null){
            user.setFirstName(entry.getFirstName());
        }
        if(entry.getFirstName() != null){
            user.setLastName(entry.getFirstName());
        }
        if(entry.getEmailId() != null){
            user.setEmailId(entry.getEmailId());
        }
        if(entry.getPassword() != null){
            user.setPassword(entry.getPassword());
        }
        if(user.getCreatedAt() == null){
            user.setCreatedAt(LocalDateTime.now());
        }
        user.setUpdatedAt(LocalDateTime.now());

        return user;
    }
}
