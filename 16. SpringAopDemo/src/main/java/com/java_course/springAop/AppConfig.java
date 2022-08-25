package com.java_course.springAop;

import org.springframework.context.annotation.*;

/**
 * @Configuration - конфигурационный файл
 * @EnableAspectJAutoProxy - для работы Spring AOP
 * @ComponentScan("com.java_course.springAop") - поиск всех бинов в указанной папке
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.java_course.springAop")
public class AppConfig {
}