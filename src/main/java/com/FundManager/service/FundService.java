package com.FundManager.service;

import com.FundManager.domain.Fund;
import com.FundManager.domain.User;

public interface FundService  {
    void create(Fund fund, User user);
    Fund getFundByName(String name);
    boolean isExist(String name);
    User getManager(Fund fund);
    Fund getFundById(String fundId);
}
