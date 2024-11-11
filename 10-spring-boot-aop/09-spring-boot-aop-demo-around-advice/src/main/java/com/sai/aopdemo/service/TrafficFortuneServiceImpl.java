package com.sai.aopdemo.service;

import java.util.concurrent.TimeUnit;

public class TrafficFortuneServiceImpl implements TrafficFortuneService{

    @Override
    public String getFortune() {

        // simulate a delay

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // return a fortune
        return "Expect heavy traffic this morning";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if(tripWire){
            throw new RuntimeException("Mjor accident!!!!");
        }
        return getFortune();
    }

}
