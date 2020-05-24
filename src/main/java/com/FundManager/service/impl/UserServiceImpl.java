package com.FundManager.service.impl;

import com.FundManager.domain.User;
import com.FundManager.domain.repository.UserRepository;
import com.FundManager.form.UserForm;
import com.FundManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUser(UserForm userForm) {
        //userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userRepository.addUser(userForm);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.userExists(username);
    }
}
