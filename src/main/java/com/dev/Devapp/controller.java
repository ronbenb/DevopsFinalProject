package com.dev.Devapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    private final LoggingService loggingService;

    public controller(LoggingService loggingService) {
        this.loggingService = loggingService;
    }
    @GetMapping("/")
    public String index1() {
        loggingService.logEndpointAccess("/");
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/logs")
    public String index() {
        loggingService.logEndpointAccess("/logs");
        return "logs";
    }

}