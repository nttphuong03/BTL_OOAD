package com.FundManager.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Fund implements Serializable {
    private String fundId;
    private User manage;

    @Size(min = 4, max = 16, message = "{Size.Fund.fundName.validation}")
    private String fundName;

    private String description;

    @Min(value=0, message = "{Min.Fund.moneyOfFund.validation}")
    private long moneyOfFund;

    private Timestamp ngayTao;

    private List<Transaction> transactionList;

    private List<Member_Fund> memberList;


    public Fund(){
        transactionList = new ArrayList<>();
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public List<Member_Fund> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member_Fund> memberList) {
        this.memberList = memberList;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public User getManage() {
        return manage;
    }

    public void setManage(User manage) {
        this.manage = manage;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getMoneyOfFund() {
        return moneyOfFund;
    }

    public void setMoneyOfFund(long moneyOfFund) {
        this.moneyOfFund = moneyOfFund;
    }

    public Timestamp getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }
}
