package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspect {

    @Before("@annotation(TestAnnotation)")
    public void print(JoinPoint joinPoint) {
        System.out.println("Printing from aspect! Arguments : " + joinPoint.getArgs());
    }

}
