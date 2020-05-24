package com.FundManager.domain;


import com.FundManager.domain.repository.TypeOfTransaction;
import org.codehaus.jackson.map.ext.JodaDeserializers;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Timestamp;


@Entity
public class Transaction implements Serializable {

    private String transactionName;
    private int money;


    @Enumerated(EnumType.ORDINAL)
    private TypeOfTransaction type;

    private Timestamp ngayTao;
    private User nguoiTao;


    public User getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(User nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public TypeOfTransaction getType() {
        return type;
    }

    public void setType(TypeOfTransaction type) {
        this.type = type;
    }

    public Timestamp getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }
}
