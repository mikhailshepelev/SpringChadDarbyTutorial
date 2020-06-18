package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    //this is where we add all of our related advices for logging

    //let's start with an @Before advice

    //this method call any method with this name in any class
    //@Before("execution(public void addAccount())")

    //will run this method only for method specified
    //@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")

    //will run for any method started with add
    //@Before("execution(public void add*())")

    //modifier is optional and return type is also optional, can be replaced with *
    //we can add fully qualified name into brackets as single parameter
    // .. means 0 or more of any params
    //@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")

    //@Before("execution(* add*(..))")

    //first start return type, second - class name, third - method name
    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====> Executing @Before advice on addAccount()");
    }
}
