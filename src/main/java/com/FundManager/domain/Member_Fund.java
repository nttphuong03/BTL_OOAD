package com.FundManager.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Member_Fund implements Serializable {

    private User user;
    private Fund fund;
    private Timestamp ngaythamgia;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public Timestamp getNgaythamgia() {
        return ngaythamgia;
    }

    public void setNgaythamgia(Timestamp ngaythamgia) {
        this.ngaythamgia = ngaythamgia;
    }
}
