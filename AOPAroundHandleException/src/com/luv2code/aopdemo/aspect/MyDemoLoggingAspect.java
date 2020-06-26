package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2) //defines order (lower the number - higher priority)
public class MyDemoLoggingAspect {
    
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        //print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n====> Executing @Around on method: " + method);

        //get begin timestamp
        long begin = System.currentTimeMillis();

        //now, let's execute the method
        Object result = null;

        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception e) {
            //log the exception
            myLogger.warning(e.getMessage());
            //give user a custom message
            result = "Major accident! But no worries, " +
                    "your private AOP helicopter is on the way!";

            //we can also rethrow exception
            //throw e;
        }

        //get end timestamp
        long end = System.currentTimeMillis();

        //compute duration and display it
        long duration = end - begin;
        myLogger.info("\n====> Duration: " + duration / 1000.0 + " seconds");
        return result;
    }

    //@After runs before @AfterThrowing and regardless of outcome of method
    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n====> Executing @After on method: " + method);
    }

    //add a new advice for @AfterThrowing on the findAccounts method
    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){
        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n====> Executing @AfterReturning on method: " + method);

        //log the exception
        myLogger.info("\n====> The exception is: " + theExc);
    }

    //add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result" //this should match with param in method signature
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n====> Executing @AfterReturning on method: " + method);

        //print out the results of the method call
        myLogger.info("\n====> result is: " + result);

        //let's post-process the data ... let's modify it

        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        myLogger.info("\n====> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        //loop through accounts
        for(Account tempAccount : result) {
            //get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();
            //update the name on the account
            tempAccount.setName(theUpperName);
        }
    }

    //join point allows to get information in aspect about method arguments and signature
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDAOpackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        myLogger.info("\n=====> Executing @Before advice on addAccount()");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("Method: " + methodSignature);

        //display method arguments

        //get args
        Object[] args = theJoinPoint.getArgs();

        //loop thru args
        for (Object tempArg: args) {
            myLogger.info(tempArg.toString());
            if (tempArg instanceof Account) {
                //downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;
                myLogger.info("account name: " + theAccount.getName());
                myLogger.info("account level: " + theAccount.getLevel());
            }
        }
    }

}
