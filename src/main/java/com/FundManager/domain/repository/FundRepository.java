package com.FundManager.domain.repository;

import com.FundManager.domain.Fund;
import com.FundManager.domain.User;

public interface FundRepository {
    void create(Fund fund, User user);
    Fund getFundByName(String fundName);
    boolean isExist(String fundName);
    User getManager(Fund fund);
    Fund getFundById(String fundId);
}
