package com.flamexander.cloud.client;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingControllerImpl implements GreetingController {
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${userValue}")
    private String username;

    @Override
    public String greeting() {
        return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
    }

	@GetMapping("/abc")
    public void test() {
        System.out.println(username);
    }

    @GetMapping("/abcr")
    public String abcr() {
        return "ABC";
    }
	@Override
	@GetMapping("/parametrized/{id}")
	public String parametrized(@PathVariable(value = "id") String id) {
		return "Id: " + id;
	}

}
