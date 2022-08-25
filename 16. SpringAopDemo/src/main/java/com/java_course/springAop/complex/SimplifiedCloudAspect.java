package com.java_course.springAop.complex;

import org.aspectj.lang.annotation.Before;

//@Aspect
//@Component
//@Order(1000)
public class SimplifiedCloudAspect {
    @Before("execution(public * com.geekbrains.aop.UserDAO.*(..))")
    public void allMethodsCallsSendInfoToCloud() {
        System.out.println("В классе UserDAO вызывают метод (Cloud)");
    }
}
