package com.java_course.springAop.complex;

import org.aspectj.lang.annotation.Before;

// @Aspect
// @Component
public class ComplexAspect {
    @Before("execution(public * com.java_course.springAop.UserDAO.*(..))")
    public void allMethodsCallsLogging() {
        System.out.println("В классе UserDAO вызывают метод");
    }

    @Before("execution(public * com.java_course.springAop.UserDAO.*(..))")
    public void allMethodsCallsAnalytics() {
        System.out.println("В классе UserDAO вызывают метод (Аналитика)");
    }

    @Before("execution(public * com.java_course.springAop.UserDAO.*(..))")
    public void allMethodsCallsSendInfoToCloud() {
        System.out.println("В классе UserDAO вызывают метод (Cloud)");
    }
}
