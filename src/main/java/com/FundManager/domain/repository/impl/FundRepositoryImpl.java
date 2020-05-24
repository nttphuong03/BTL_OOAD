package com.FundManager.domain.repository.impl;

import com.FundManager.domain.Fund;
import com.FundManager.domain.User;
import com.FundManager.domain.repository.FundRepository;
import com.FundManager.service.Member_FundService;
import com.FundManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FundRepositoryImpl implements FundRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;

    @Autowired
    Member_FundService memberFundService;

    @Override
    public void create(Fund fund, User user) {
        String sql = "insert into fund(fundId,fundName,managerUsername,description,ngayTao,moneyInit)" +
                     "values (:fundId,:fundName,:managerUsername,:description,:ngayTao,:moneyInit)";
        Map<String,Object> params = new HashMap<>();
        params.put("fundId",fund.getFundId());
        params.put("fundName",fund.getFundName());
        params.put("managerUsername",user.getUsername());
        params.put("description",fund.getDescription());
        params.put("ngayTao",fund.getNgayTao());
        params.put("moneyInit",fund.getMoneyOfFund());

        jdbcTemplate.update(sql,params);

        //them vao bang member
        memberFundService.addMF(user, fund);
    }

    @Override
    public Fund getFundByName(String name) {
        String sql = "select * from fund where fundName = :fundName";
        Map<String,Object> params = new HashMap<>();
        params.put("fundName",name);
        List<Fund> funds = jdbcTemplate.query(sql,params,new FundMapper());
        if (funds.size() > 0) return funds.get(0);
        return null;
    }

    @Override
    public boolean isExist(String fundName) {
        String sql = "select * from fund where fundName = :fundName";
        Map<String,Object> params = new HashMap<>();
        params.put("fundName",fundName);
        List<Fund> funds = jdbcTemplate.query(sql,params,new FundMapper());
        if (funds.size() > 0) return true;
        return false;
    }

    @Override
    public User getManager(Fund fund) {
     return fund.getManage();
    }

    @Override
    public Fund getFundById(String fundId) {
        String sql = "select * from fund where fundId = :fundId";
        Map<String,Object> params = new HashMap<>();
        params.put("fundId",fundId);
        List<Fund> funds = jdbcTemplate.query(sql,params,new FundMapper());
        return  funds.get(0);
    }
}
