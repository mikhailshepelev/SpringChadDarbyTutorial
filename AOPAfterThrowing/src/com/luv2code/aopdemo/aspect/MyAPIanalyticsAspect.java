package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3) //defines order (lower the number - higher priority)
public class MyAPIanalyticsAspect {

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDAOpackageNoGetterSetter()")
    public void performAPIAnalytics(){
        System.out.println("\n=====> Performing API analytics");
    }
}
