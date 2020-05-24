package com.FundManager.domain.repository.impl;

import com.FundManager.domain.Member_Fund;
import com.FundManager.domain.User;
import com.FundManager.domain.repository.Member_FundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserMapper implements RowMapper<User> {

    @Autowired
    Member_FundRepository memberFundRepository;

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
        List<Member_Fund> fundList  = memberFundRepository.getAllFund(user.getUsername());
        user.setFundList(fundList);
        return user;
    }
}
