package com.sai.aopdemo.dao;

import java.util.List;

import com.sai.aopdemo.Account;

public interface AccountDAO {

    List<Account> findAccounts();

    void addAccount(Account theAccount,boolean vipFlag);

    boolean doWork();

    public String getName();
     
    public void setName(String name); 

    public String getServiceCode();

    public void setServiceCode(String serviceCode);


}
