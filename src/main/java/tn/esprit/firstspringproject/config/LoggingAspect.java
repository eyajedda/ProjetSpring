package tn.esprit.firstspringproject.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* tn.esprit.firstspringproject.services.FoyerService.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }



        @After("execution(* tn.esprit.firstspringproject.services.FoyerService.*(..))")
        public void logMethodExit(JoinPoint joinPoint) {
            String name= joinPoint.getSignature().getName();
            log.info("Out method : " + name);
        }

        @AfterReturning("execution(* tn.esprit.firstspringproject.services.FoyerService.*(..))")
        public void logMethodExitReturning(JoinPoint joinPoint) {
            String name= joinPoint.getSignature().getName();
            log.info("Out method with succes : " + name);
        }
        @AfterThrowing("execution(* tn.esprit.firstspringproject.services.FoyerService.*(..))")
        public void logMethodExitReturningEror(JoinPoint joinPoint) {
            String name= joinPoint.getSignature().getName();
            log.info("Out method with Error : " + name);
        }

    }



