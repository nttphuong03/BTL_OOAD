package com.FundManager.service.impl;

import com.FundManager.domain.Fund;
import com.FundManager.domain.Member_Fund;
import com.FundManager.domain.User;
import com.FundManager.domain.repository.Member_FundRepository;
import com.FundManager.service.Member_FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Member_FundServiceImpl implements Member_FundService {

    @Autowired
    Member_FundRepository memberFundRepository;
    @Override
    public void addMF(User user, Fund fund) {
        memberFundRepository.addMF(user,fund);
    }

    @Override
    public List<Member_Fund> getAllMember(Fund fund) {
        return memberFundRepository.getAllMember(fund);
    }

    @Override
    public List<Member_Fund> getAllFund(String username) {
        return memberFundRepository.getAllFund(username);
    }
}
