package com.cashrich.identity.api;


import com.cashrich.identity.entry.ResponseEntry;
import com.cashrich.identity.entry.UserEntry;
import com.cashrich.identity.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApi {

    UserManager userManager;
    @Autowired
    UserApi (UserManager userManager){
        this.userManager = userManager;
    }


    @GetMapping("api/user/{id}")
    public ResponseEntry<UserEntry> getUser(@PathVariable Integer id) throws Exception {
        return userManager.getUser(id);
    }

    @PostMapping("api/user/signup")
    public ResponseEntry<UserEntry> insertUser(@RequestBody UserEntry userEntry) throws Exception {
        return userManager.insertUser(userEntry);
    }
    @PostMapping("api/user/login")
    public ResponseEntry<UserEntry> loginUser(@RequestBody UserEntry userEntry) throws Exception {
        return userManager.loginUser(userEntry);
    }

    @PutMapping("api/user/update")
    public ResponseEntry<UserEntry> updateUser(@RequestBody UserEntry userEntry) throws Exception {
        return userManager.updateUser(userEntry);
    }
}
