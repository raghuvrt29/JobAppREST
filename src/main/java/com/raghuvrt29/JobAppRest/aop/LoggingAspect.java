package com.raghuvrt29.JobAppRest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //("execution(returnType className.methodName(args))")
    @Before("execution(* com.raghuvrt29.JobAppRest.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }

    @After("execution(* com.raghuvrt29.JobAppRest.service.JobService.*(..))")
    public void logMethodExecute(JoinPoint jp){
        LOGGER.info("Method executed " + jp.getSignature().getName());
    }

}
