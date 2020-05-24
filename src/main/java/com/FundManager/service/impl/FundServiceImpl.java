package com.FundManager.service.impl;

import com.FundManager.domain.Fund;
import com.FundManager.domain.User;
import com.FundManager.domain.repository.FundRepository;
import com.FundManager.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundServiceImpl implements FundService {
    @Autowired
    FundRepository fundRepository;

    @Override
    public void create(Fund fund, User user) {
        fundRepository.create(fund,user);
    }

    @Override
    public Fund getFundByName(String name) {
        return fundRepository.getFundByName(name);
    }

    @Override
    public boolean isExist(String name) {
        return fundRepository.isExist(name);
    }

    @Override
    public User getManager(Fund fund) {
        return fundRepository.getManager(fund);
    }

    @Override
    public Fund getFundById(String fundId) {
        return fundRepository.getFundById(fundId);
    }
}
