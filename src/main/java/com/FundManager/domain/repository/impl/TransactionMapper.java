package com.FundManager.domain.repository.impl;

import com.FundManager.domain.Transaction;
import com.FundManager.domain.repository.TypeOfTransaction;
import com.FundManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionMapper implements RowMapper<Transaction> {

    @Autowired
    UserService userService;

    @Override
    public Transaction mapRow(ResultSet rs, int i) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setTransactionName(rs.getString("transactionName"));
        transaction.setType(TypeOfTransaction.valueOf(rs.getString("type") ));
        transaction.setMoney(rs.getInt("money"));
        transaction.setNgayTao(rs.getTimestamp("ngayTao"));
        String username = rs.getString("nguoiTao");
        transaction.setNguoiTao(userService.getUserByUsername(username));

        return transaction;

    }
}
