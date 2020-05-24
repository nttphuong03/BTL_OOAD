package com.FundManager.service;

import com.FundManager.domain.User;
import com.FundManager.form.UserForm;

public interface UserService {
    void addUser (UserForm userForm);
    User getUserByUsername(String username);
    boolean userExists (String username);
}
