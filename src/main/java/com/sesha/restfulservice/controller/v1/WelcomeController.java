package com.sesha.restfulservice.controller.v1;

import com.sesha.restfulservice.dto.Welcome;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WelcomeController {

    @Value("${spring.application.name}")
    String appName;

    private static final String text = "hello, you're using app %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/welcome")
    public Welcome homePage(@RequestParam(value = "name", defaultValue = "default name") String textName) {
        return new Welcome(counter.incrementAndGet(), appName, String.format(text, textName));
    }
}
