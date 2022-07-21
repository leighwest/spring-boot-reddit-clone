package com.west.springit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        // do some database work
        System.out.println("Database Loader...");
    }
}
