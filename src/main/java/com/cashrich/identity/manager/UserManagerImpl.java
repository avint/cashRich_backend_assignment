package com.cashrich.identity.manager;

import com.cashrich.identity.utils.CommonUtils;
import com.cashrich.identity.dao.UserDao;
import com.cashrich.identity.utils.TransformUtil;
import com.cashrich.identity.entity.User;
import com.cashrich.identity.entry.ResponseEntry;
import com.cashrich.identity.entry.StatusEntry;
import com.cashrich.identity.entry.UserEntry;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserManagerImpl implements UserManager{
    @Autowired
    UserDao userDao;

    @Autowired
    TransformUtil transformUtil;

    @Autowired
    CommonUtils commonUtils;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    public ResponseEntry<UserEntry> getUser(Integer id) throws Exception {

        Optional<User> user = userDao.getUser(id);

        if(user.isPresent()){
            return convertToResponseEntry("", "200","SUCCESS", true, transformUtil.entityToEntry(user));
        }else{
            return convertToResponseEntry("User not found", "600","FAILURE", false, null);
        }
    }

    public ResponseEntry<UserEntry> insertUser(UserEntry userEntry) throws Exception {

        if(!commonUtils.validatePassword(userEntry.getPassword())){
            return convertToResponseEntry("Password has to be 8 to 15 in length with mix of atleast 1 upper, 1 lower, 1 digit and 1 special character", "800","FAILURE", false, userEntry);
        }
//        userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));

        if(!commonUtils.validateUsername(userEntry.getUserName())){
            return convertToResponseEntry("Username has to be character and digits only with length of 4 to 15", "800","FAILURE", false, userEntry);
        }
        try{

            User user = userDao.createUser(transformUtil.entryToEntity(userEntry, null));

            if(user != null) {
                return convertToResponseEntry("", "200","SUCCESS", true, transformUtil.entityToEntry(Optional.of(user)));
            }else{
                return convertToResponseEntry("User not found", "600","FAILURE", false, null);
            }
        }catch (Exception e){
            throw new Exception("UserName or Email already exists: ", e);
        }
    }
    public ResponseEntry<UserEntry> loginUser(UserEntry userEntry) throws Exception {

        if (userEntry.getUserName() == null) {
            throw new Exception("User not found with username: " + null);
        }
        if (userEntry.getPassword() == null) {
            throw new Exception("password is mandatory");
        }
        User user;
        try{
            user = userDao.getUserByUsername(userEntry.getUserName());
            if(user == null) {
                return convertToResponseEntry("User not found", "600","FAILURE", false, null);
            }
        }catch (Exception e){
            throw new Exception("UserName not found: ", e);
        }
//        if(!passwordEncoder.encode(userEntry.getPassword()).equals(user.getPassword())){
//            throw new Exception("Password incorrect");
//        }
        UserEntry entry = transformUtil.entityToEntry(Optional.of(user));


        return convertToResponseEntry("", "200","SUCCESS", true, entry);
    }
    public ResponseEntry<UserEntry> updateUser(UserEntry userEntry) throws Exception {

        if (userEntry.getId() == null) {
            return convertToResponseEntry("UserName not found", "600","FAILURE", false, userEntry);
        }
        if(this.getUser(userEntry.getId())  == null){
            return convertToResponseEntry("User not found", "600","FAILURE", false, userEntry);
        }
        if(!commonUtils.validateUsername(userEntry.getUserName())){
            return null;
        }
        try{
            User user = userDao.createUser(transformUtil.entryToEntity(userEntry, null));

            if(user != null) {
                return convertToResponseEntry("", "200","SUCCESS", true, transformUtil.entityToEntry(Optional.of(user)));
            }else{
                return convertToResponseEntry("User not found", "600","FAILURE", false, null);
            }
        }catch (Exception e){
            throw new Exception("UserName or Email already exists: ", e);
        }
    }

    public ResponseEntry<UserEntry> convertToResponseEntry(String msg, String code, String status, Boolean success, UserEntry data){
        StatusEntry statusEntry = new StatusEntry();
        statusEntry.setCode(code);
        statusEntry.setStatus(status);
        statusEntry.setSuccess(success);
        statusEntry.setMessage(msg);
        statusEntry.setTimeStamp(LocalDateTime.now());

        ResponseEntry<UserEntry> response = new ResponseEntry<UserEntry>();
        response.setStatusEntry(statusEntry);
        response.setData(data);
        return response;
    }

}
