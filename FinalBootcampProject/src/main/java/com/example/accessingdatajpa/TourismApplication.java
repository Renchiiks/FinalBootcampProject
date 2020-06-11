package com.example.accessingdatajpa;

import com.example.accessingdatajpa.storage.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties({FileStorageProperties.class})
public class TourismApplication {

    public static void main(String[] args) {
        SpringApplication.run(TourismApplication.class, args);
    }



}
