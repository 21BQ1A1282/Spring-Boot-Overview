package com.sai.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sai.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {


    @Before("com.sai.aopdemo.aspect.SaiAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args=theJoinPoint.getArgs();

        // loop through args
        for(Object tempObject:args){
            System.out.println(tempObject);

            if(tempObject instanceof Account){
                Account account=(Account) tempObject;

                System.out.println("account name: "+ account.getName());
                System.out.println("account level: "+ account.getLevel());
            }
        }
    }
}
