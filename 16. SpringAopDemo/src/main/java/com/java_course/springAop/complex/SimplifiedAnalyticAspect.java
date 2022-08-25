package com.java_course.springAop.complex;

import org.aspectj.lang.annotation.Before;

//@Aspect
//@Component
//@Order(200)
public class SimplifiedAnalyticAspect {
    @Before("execution(public * com.geekbrains.aop.UserDAO.*(..))")
    public void allMethodsCallsAnalytics() {
        System.out.println("В классе UserDAO вызывают метод (Аналитика)");
    }
}
