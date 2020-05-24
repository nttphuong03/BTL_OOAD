package com.FundManager.domain.repository.impl;

import com.FundManager.domain.Fund;
import com.FundManager.domain.Member_Fund;
import com.FundManager.domain.User;
import com.FundManager.service.FundService;
import com.FundManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Member_FundMapper implements RowMapper<Member_Fund> {

    @Autowired
    UserService userService;

    @Autowired
    FundService fundService;

    @Override
    public Member_Fund mapRow(ResultSet rs, int i) throws SQLException {
       Member_Fund member = new Member_Fund();
       String username = rs.getString("username");
       User user = userService.getUserByUsername(username);

       String fundId = rs.getString("fundId");
       Fund fund = fundService.getFundById("fundId");

       member.setFund(fund);
       member.setUser(user);
       member.setNgaythamgia(rs.getTimestamp("ngaythamgia"));

       return member;
    }
}
