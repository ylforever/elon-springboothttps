package com.elon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class StartSBHApplication {
    private static final Logger LOGGER = LogManager.getLogger(StartSBHApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StartSBHApplication.class);
        LOGGER.info("Start up StartSBHApplication finish.");
    }
}
