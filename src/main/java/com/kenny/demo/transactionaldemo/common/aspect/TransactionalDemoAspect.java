package com.kenny.demo.transactionaldemo.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TransactionalDemoAspect {

    @Around("execution(* com.kenny.demo.transactionaldemo.ui..*.*(..))")
    public Object commonControllerAspect(final ProceedingJoinPoint pjp) throws Throwable {
        log.debug( "__KENNY__ commonControllerAspect START");

        Object result;
        try {
            log.debug( "__KENNY__ commonControllerAspect Try");

            result = pjp.proceed();

        } catch ( Exception e ) {
            log.debug( "__KENNY__ commonControllerAspect Catch" );

            throw e;

        } finally {
            log.debug( "__KENNY__ commonControllerAspect Finally");
        }

        return result;
    }
}
