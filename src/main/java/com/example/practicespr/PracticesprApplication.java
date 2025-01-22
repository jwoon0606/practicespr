package com.example.practicespr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class PracticesprApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticesprApplication.class, args);
    }

}
