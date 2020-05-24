package com.FundManager.domain.repository.impl;

import com.FundManager.domain.User;
import com.FundManager.domain.repository.UserRepository;
import com.FundManager.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    PasswordEncoder passwordEncoder

    @Override
    public void addUser(UserForm userForm) {
        String sql = "insert into customers(username,`password`,lastName,firstName,email,phone) values(:username,:password,:lastName,:firstName,:email,:phone)";
        Map<String,Object> params  = new HashMap<>();
        params.put("username",userForm.getUsername());
        params.put("password",passwordEncoder.encode(userForm.getPassword()));
        params.put("lastName",userForm.getLastName());
        params.put("firstName",userForm.getFirstName());
        params.put("email",userForm.getEmail());
        params.put("phone",userForm.getPhone());
        jdbcTemplate.update(sql,params);
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = "select * from customers where username = :username";
        Map<String,Object> params  = new HashMap<>();
        params.put("username", username);
        List<User> users = jdbcTemplate.query(sql,params,new UserMapper());
        return (users.size() > 0) ? users.get(0): null;

    }

    @Override
    public boolean userExists(String username) {
        User user = getUserByUsername(username);
        if(user == null) return false;
        return true;
    }

}
