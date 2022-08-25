package com.flamexander.cloud.client;

import org.springframework.web.bind.annotation.*;

public interface GreetingController {
    @RequestMapping("/greeting")
    String greeting();

    @GetMapping("/parametrized/{id}")
    String parametrized(@PathVariable(value = "id") String id);
}
