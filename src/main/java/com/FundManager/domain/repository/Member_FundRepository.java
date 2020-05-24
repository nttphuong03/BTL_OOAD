package com.FundManager.domain.repository;

import com.FundManager.domain.Fund;
import com.FundManager.domain.Member_Fund;
import com.FundManager.domain.User;

import java.util.List;

public interface Member_FundRepository {
    void addMF(User user, Fund fund);
    List<Member_Fund> getAllMember(Fund fund);
    List<Member_Fund> getAllFund(String username);
}
