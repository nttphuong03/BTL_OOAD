package com.FundManager.domain.repository;

import com.FundManager.domain.User;
import com.FundManager.form.UserForm;

public interface UserRepository {
    void addUser(UserForm userForm);
    User getUserByUsername( String username);
    boolean userExists(String username);
}
