package com.flamexander.cloud.secured.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableEurekaClient
// @EnableCircuitBreaker
@EnableResourceServer
public class SecuredClientApp {
    public static void main(String[] args) {
        SpringApplication.run(SecuredClientApp.class, args);
    }
}
