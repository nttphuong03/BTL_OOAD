package com.FundManager.domain.repository.impl;

import com.FundManager.domain.Fund;
import com.FundManager.domain.Member_Fund;
import com.FundManager.domain.Transaction;
import com.FundManager.domain.User;
import com.FundManager.service.Member_FundService;
import com.FundManager.service.TransactionService;
import com.FundManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FundMapper implements RowMapper<Fund> {

    @Autowired
    UserService userService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    Member_FundService memberFundService;

    @Override
    public Fund mapRow(ResultSet resultSet, int i) throws SQLException {
        Fund fund  = new Fund();
        fund.setFundId(resultSet.getString("fundId"));
        fund.setFundName(resultSet.getString("fundName"));

        String username = resultSet.getString("managerUsername");
        User manager = userService.getUserByUsername(username);
        fund.setManage(manager);

        fund.setNgayTao(resultSet.getTimestamp("ngayTao"));
        fund.setMoneyOfFund(resultSet.getLong("moneyInit"));

        List<Transaction> transactionList = transactionService.getAllTransactionByFundId(resultSet.getString("fundId"));
        fund.setTransactionList(transactionList);

        List<Member_Fund> member = memberFundService.getAllMember(fund);
        fund.setMemberList(member);

        return fund;
    }
}
