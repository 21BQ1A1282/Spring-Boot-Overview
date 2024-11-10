package com.sai.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addSillyMember() {

        System.out.println(getClass()+":Doing my work: Adding An Member Account");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass()+":Going to sleep");
    }

}
