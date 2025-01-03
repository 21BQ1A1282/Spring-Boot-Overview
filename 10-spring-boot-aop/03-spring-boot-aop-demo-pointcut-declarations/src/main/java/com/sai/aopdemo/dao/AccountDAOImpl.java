package com.sai.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.sai.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {



    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {

        System.out.println(getClass()+":Doing my work: Adding An Account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+":doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    
}
