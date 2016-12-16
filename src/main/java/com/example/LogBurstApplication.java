package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class LogBurstApplication {

    Logger logger = LoggerFactory.getLogger(LogBurstApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LogBurstApplication.class, args);
    }

    @Scheduled(fixedDelay = 10000)
    public void log() {
        for (int i = 0; i < 200; i++) {
            int tryI = (int) (Math.random() * 100);
            if (tryI < 20) {
                logger.trace("its a info message");
            } else if (tryI < 40) {
                logger.debug("its a debug message");
            } else if (tryI < 60) {
                logger.info("its a info message");
            } else if (tryI < 80) {
                logger.warn("its a info message");
            } else if (tryI > 80) {
                logger.error("its a info message");
            }
        }
    }
}
