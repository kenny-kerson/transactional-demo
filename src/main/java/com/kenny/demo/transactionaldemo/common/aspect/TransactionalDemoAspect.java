package com.kenny.demo.transactionaldemo.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class TransactionalDemoAspect {

    @Around("execution(* com.kenny.demo.transactionaldemo.ui..*.*(..))")
    public Object commonControllerAspect(final ProceedingJoinPoint pjp) throws Throwable {
        log.debug( "__KENNY__ commonControllerAspect START");

        Object result;
        try {
            result = pjp.proceed();


        } catch ( Exception e ) {
            log.debug( "__KENNY__ commonControllerAspect catch : ", e);

            throw e;

        } finally {
            log.debug( "__KENNY__ commonControllerAspect finally");
        }

        return result;
    }
}
