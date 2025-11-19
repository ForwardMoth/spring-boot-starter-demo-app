package com.aop.logging_starter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

    @Around("@within(org.springframework.stereotype.Service)")
    public Object logServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            Logger targetLogger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
            String methodName = joinPoint.getSignature().getName();
            targetLogger.info("Method '{}' executed in {} ms", methodName, executionTime);
        }
    }

}
