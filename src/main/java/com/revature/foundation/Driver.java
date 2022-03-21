package com.revature.foundation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // implies both @Configuration and @ComponentScan com.revature.foundation.services
//@ComponentScan("com.revature.foundation.services")
public class Driver {

    private static Logger logger = LogManager.getLogger(Driver.class);
    public static void main(String[] args) {

        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warn message");
        logger.error("Error message");
        logger.fatal("Fatal message");
        SpringApplication.run(Driver.class, args);
    }

}