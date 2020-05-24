package com.FundManager.domain.repository.impl;

import com.FundManager.domain.Fund;
import com.FundManager.domain.Member_Fund;
import com.FundManager.domain.User;
import com.FundManager.domain.repository.Member_FundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Member_FundRepositoryImpl implements Member_FundRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void addMF(User user, Fund fund) {
        String sql = "insert into members(fundId,username,ngaythamgia)" +
                      "values(:fundId,:username,:ngaythamgia)";
        Map<String,Object> params = new HashMap<>();
        params.put("username",user.getUsername());
        params.put("fundId",fund.getFundId());
        params.put("ngaythamgia",fund.getNgayTao());

        jdbcTemplate.update(sql,params);

    }

    @Override
    public List<Member_Fund> getAllMember(Fund fund) {
        String sql = "select * from members where fundId = :fundId";
        Map<String,Object> params = new HashMap<>();
        params.put("fundId",fund.getFundId());
        List<Member_Fund> result = jdbcTemplate.query(sql,params,new Member_FundMapper());
        return result;
    }

    @Override
    public List<Member_Fund> getAllFund(String username) {
        String sql = "select * from members where username = :username";
        Map<String,Object> params = new HashMap<>();
        params.put("username", username);
        List<Member_Fund> result = jdbcTemplate.query(sql,params,new Member_FundMapper());
        return result;
    }
}
