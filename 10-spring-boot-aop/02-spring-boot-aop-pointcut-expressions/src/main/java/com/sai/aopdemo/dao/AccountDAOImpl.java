package com.sai.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.sai.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {

        System.out.println(getClass()+":Doing my work: Adding An Account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+":doWork()");
        return false;
    }

}
