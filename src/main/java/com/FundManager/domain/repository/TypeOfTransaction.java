package com.FundManager.domain.repository;



public enum TypeOfTransaction {
    ADD("ADD"),SUB("SUB");
    private final String val;
    TypeOfTransaction(String name){
        this.val = name;
    }
    public boolean isADD(String val){
        return this == ADD;
    }
    public boolean isSUB(String val){
        return this == SUB;
    }
    public String getStatus(){
        return this.val;
    }
}
