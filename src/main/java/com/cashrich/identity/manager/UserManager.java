package com.cashrich.identity.manager;

import com.cashrich.identity.entry.ResponseEntry;
import com.cashrich.identity.entry.UserEntry;

public interface UserManager {

    public ResponseEntry<UserEntry> getUser(Integer id) throws Exception;

    public ResponseEntry<UserEntry> insertUser(UserEntry userEntry) throws Exception;

    public ResponseEntry<UserEntry> loginUser(UserEntry userEntry) throws Exception;

    public ResponseEntry<UserEntry> updateUser(UserEntry userEntry) throws Exception;

}
