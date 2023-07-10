package com.dev.Devapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SeedDataLoader implements CommandLineRunner {

    private final LoggingService loggingService;

    @Autowired
    public SeedDataLoader(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    public void run(String... args) {
        String serverStartTime = getCurrentTime();
        String logMessage = "Seed data loaded. Server started at: " + serverStartTime;
        loggingService.logEndpointAccess(logMessage);
    }

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
