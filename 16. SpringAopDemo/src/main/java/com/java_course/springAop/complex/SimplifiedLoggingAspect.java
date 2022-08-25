package com.java_course.springAop.complex;

import org.aspectj.lang.annotation.Before;

//@Aspect
//@Component
//@Order(-100)
public class SimplifiedLoggingAspect {
    @Before("execution(public * com.geekbrains.aop.UserDAO.*(..))")
    public void allMethodsCallsLogging() {
        System.out.println("В классе UserDAO вызывают метод (Logging)");
    }
}
