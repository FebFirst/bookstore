package com.bookstore.AOP;

import com.bookstore.model.Customer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by googo on 10/05/2017.
 */
@Aspect
@Component
//@Order
public class BKStoreLogging {

    private Logger logger = Logger.getLogger("Book Store Log");

    @Pointcut("execution(* com.bookstore.controller.AuthController.log*(..))")
    private void aspectjLogInOutCut(){}

    @Pointcut("execution(* com.bookstore.controller.BookController.*(..))")
    private void aspectjBookControllerCut(){}


    @Before("aspectjLogInOutCut()")
    public void afterLogIn(JoinPoint joinPoint){
        Customer customer = (Customer)joinPoint.getArgs()[0];
        logger.log(Level.INFO, "Before: User " + customer.getId() + " uses method " + joinPoint.getSignature().getName());
    }
    @AfterReturning("aspectjLogInOutCut()")
    public void LogInOutLog(JoinPoint joinPoint){
        Customer customer = (Customer)joinPoint.getArgs()[0];
        logger.log(Level.INFO, "AfterReturn: User " + customer.getId() + " uses method " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("aspectjLogInOutCut()")
    public void LogInOutExceptionLog(JoinPoint joinPoint){
        Customer customer = (Customer)joinPoint.getArgs()[0];
        logger.log(Level.INFO, "Exception: User " + customer.getId() + " uses method " + joinPoint.getSignature().getName());
    }

    @Before("aspectjBookControllerCut()")
    public void beforeBookControllerMethod(JoinPoint joinPoint){
        logger.log(Level.INFO, "AfterReturn: method " + joinPoint.getSignature().getName());
    }


    @AfterReturning("aspectjBookControllerCut()")
    public void afterBookControllerMethodReturn(JoinPoint joinPoint){
        logger.log(Level.INFO, "AfterReturn: method " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("aspectjBookControllerCut()")
    public void afterBookControllerMethodThrow(JoinPoint joinPoint){
        logger.log(Level.INFO, "Exception: method " + joinPoint.getSignature().getName());
    }

}
