package com.sai.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {


        // for academic purposes ... simulate an exception
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }
        
        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account account1 = new Account("John Brown","silver");
        Account account2 = new Account("Jane Green","gold");
        Account account3 = new Account("Jim Blue","silver");

        // add them to our account list
        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);

        return myAccounts;
    }

    
}
