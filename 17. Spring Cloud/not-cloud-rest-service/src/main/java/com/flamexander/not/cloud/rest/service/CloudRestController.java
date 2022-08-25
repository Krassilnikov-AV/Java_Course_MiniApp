package com.flamexander.not.cloud.rest.service;

import com.flamexander.cloud.common.CloudPacket;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CloudRestController {
    @GetMapping("/give_me_some_data")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<CloudPacket> giveMeSomeData() {
        List<CloudPacket> list = new ArrayList<>(Arrays.asList(
                new CloudPacket(1L, "Message #1"),
                new CloudPacket(2L, "Message #2"),
                new CloudPacket(3L, "Message #3"))
        );
        return list;
    }
}
