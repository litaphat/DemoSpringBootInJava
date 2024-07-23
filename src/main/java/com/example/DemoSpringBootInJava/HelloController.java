package com.example.DemoSpringBootInJava;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        if (name == null || name.isEmpty()) {
            name = "Litaphat";
        }
        String result = String.format("Hello, %s.", name);
        return result;
    }

}
