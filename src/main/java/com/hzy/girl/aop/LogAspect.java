package com.hzy.girl.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.hzy.girl.aop.Aspect4Log)")
    public void log(){}


    @Before("log()")
    public void realLog(JoinPoint joinPoint){
        // 执行类名+方法名
        logger.info("[" + joinPoint.getSignature().getDeclaringType() + "]"
                  + "[" + joinPoint.getSignature().getName() + "]");
        logger.info("执行日志AOP");
        Object[] objects = joinPoint.getArgs();
        logger.info("args={}", objects);
        logger.info("args={}", objects[0].toString());
    }

    @Around(value = "log()")
    public void doAround(JoinPoint joinPoint){
        logger.info("[" + joinPoint.getSignature().getDeclaringType() + "." + joinPoint.getSignature().getName() + "]");
        long startTime = System.currentTimeMillis();
        try {
            ((ProceedingJoinPoint) joinPoint).proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        logger.info("耗时: " + (endTime - startTime));
    }

}
