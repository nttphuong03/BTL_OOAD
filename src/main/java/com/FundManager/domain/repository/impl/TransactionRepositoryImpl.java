package com.FundManager.domain.repository.impl;

import com.FundManager.domain.Fund;
import com.FundManager.domain.Transaction;
import com.FundManager.domain.repository.TransactionRepository;
import com.FundManager.domain.repository.TypeOfTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void addTransaction(Transaction transaction, Fund fund) {
        String sql = "Insert into transactions(fundId,transactionName,money,ngayTao,nguoiTao,`type`)" +
                     "values(:fundId,:transactionName,:money,:ngayTao,:nguoiTao,:`type` ) ";
        Map<String,Object> params = new HashMap<>();
        params.put("fundId",fund.getFundId());
        params.put("transactionName",transaction.getTransactionName());
        params.put("money",transaction.getMoney());
        params.put("ngayTao",transaction.getNgayTao());
        params.put("type", transaction.getType());
        params.put("nguoiTao",transaction.getNguoiTao().getUsername());

        namedParameterJdbcTemplate.update(sql,params);

    }

    @Override
    public List<Transaction> getTransactionByName(Transaction transaction, Fund fund) {
        String sql = "select * from transactions where transactionName = :transactionName and" +
                                "fundId = :fundId";
        Map<String,Object> params = new HashMap<>();
        params.put("transactionName",transaction.getTransactionName());
        params.put("fundId",fund.getFundId());
        return namedParameterJdbcTemplate.query(sql, params,new TransactionMapper());

    }

    @Override
    public List<Transaction> getAllTransactionByFundId(String fundId) {
        String sql = "select * from transactions where fundId = :fundId";
        Map<String,Object> params = new HashMap<>();
        params.put("fundId",fundId);
        List<Transaction> transactionList = namedParameterJdbcTemplate.query(sql,params,new TransactionMapper());
        return transactionList;
    }
}
