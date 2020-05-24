package com.FundManager.domain.repository;

import com.FundManager.domain.Fund;
import com.FundManager.domain.Transaction;

import java.util.List;

public interface TransactionRepository  {

    void addTransaction(Transaction transaction, Fund fund);
    List<Transaction> getTransactionByName(Transaction transaction, Fund fund) ;
    List<Transaction> getAllTransactionByFundId(String fundId);

}
