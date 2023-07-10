package com.dev.Devapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class controller {

    private final LoggingService loggingService;

    public controller(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @GetMapping("/logs")
    public String getLogs() {
        loggingService.logEndpointAccess("/logs");
        String logFilePath = "/logs/file.log";
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("<br>");
            }
        } catch (IOException e) {
            return "Failed to read log file: " + e.getMessage();
        }
        return stringBuilder.toString();
    }
        @GetMapping("/transactions")
    public String index1() {
        loggingService.logEndpointAccess("/transactions");
        return "transactions";
    }


    }

