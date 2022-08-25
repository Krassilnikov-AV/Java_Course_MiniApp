package com.flamexander.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * !!! EnableEurekaServer - работает на JDK 6,7,8
 * =*=*=*=*=*=*=*=* для работы на JDK 9 и выше, подключение зависимостей, представленных ниже=*=*=*=*=*=*=*=*=
 * <!-- API, java.xml.bind module -->
 * <dependency>
 *     <groupId>jakarta.xml.bind</groupId>
 *     <artifactId>jakarta.xml.bind-api</artifactId>
 *     <version>2.3.2</version>
 * </dependency>
 *
 * <!-- Runtime, com.sun.xml.bind module -->
 * <dependency>
 *     <groupId>org.glassfish.jaxb</groupId>
 *     <artifactId>jaxb-runtime</artifactId>
 *     <version>2.3.2</version>
 * </dependency>
 * */

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}