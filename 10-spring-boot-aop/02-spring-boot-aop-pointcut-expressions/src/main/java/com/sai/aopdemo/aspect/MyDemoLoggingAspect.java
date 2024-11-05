package com.sai.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


    // @Before("execution(public void addAccount())")

    // @Before("execution(public void com.sai.aopdemo.dao.AccountDAO.addAccount())")

    // @Before("execution(public void add*())")

    // @Before("execution(* add*())")


    // @Before("execution(* add*(com.sai.aopdemo.Account))")

    // @Before("execution(* add*(com.sai.aopdemo.Account, ..))")

    // @Before("execution(* add*(..))")
    
    // @Before("execution(* com.sai.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
