package com.FundManager.service;

import com.FundManager.domain.Fund;
import com.FundManager.domain.Transaction;

import java.util.List;

public interface TransactionService  {
    void addTransaction(Transaction transaction, Fund fund);
    List<Transaction> getTransactionByName(Transaction transaction, Fund fund) ;
    List<Transaction> getAllTransactionByFundId(String fundId);
}
