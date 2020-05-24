package com.FundManager.service.impl;

import com.FundManager.domain.Fund;
import com.FundManager.domain.Transaction;
import com.FundManager.domain.repository.TransactionRepository;
import com.FundManager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionSeviceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;


    @Override
    public void addTransaction(Transaction transaction, Fund fund) {
        transactionRepository.addTransaction(transaction,fund);
    }

    @Override
    public List<Transaction> getTransactionByName(Transaction transaction, Fund fund) {
        return transactionRepository.getTransactionByName(transaction,fund);
    }

    @Override
    public List<Transaction> getAllTransactionByFundId(String fundId) {
        return transactionRepository.getAllTransactionByFundId(fundId);
    }
}
