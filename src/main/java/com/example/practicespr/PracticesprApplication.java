package com.example.practicespr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // Auditing(감시) 기능 활성화, 생성일, 수정일 자동 기록 가능
@SpringBootApplication
public class PracticesprApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticesprApplication.class, args);
    }

}
