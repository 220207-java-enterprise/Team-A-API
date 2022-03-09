package com.revature.foundation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // implies both @Configuration and @ComponentScan
public class Driver {

    public static void main(String[] args) {
        SpringApplication.run(Driver.class);
    }

}