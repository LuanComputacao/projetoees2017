package com.luancomputacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MrXavierApplication {
    public static void main(String[] args) {
        SpringApplication.run(MrXavierApplication.class, args);
    }
}