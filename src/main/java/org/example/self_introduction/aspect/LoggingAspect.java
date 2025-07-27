package org.example.self_introduction.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(public * org.example.self_introduction..*(..))")
    private void allPublicMethods(){}

    /**
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("allPublicMethods()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {

        String sig = pjp.getSignature().toShortString();
        logger.info("[START] {}", sig);
        long start = System.currentTimeMillis();

        Object result = pjp.proceed();   // 실제 비즈니스 메서드 호출

        long elapsed = System.currentTimeMillis() - start;
        logger.info("[END] {} ({} ms)", sig, elapsed);
        return result;
    }
}
