package com.luancomputacao;

import com.luancomputacao.domain.Professor;
import com.luancomputacao.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaAuditing
public class MrXavierApplication implements CommandLineRunner {

    @Autowired
    private ProfessorRepository professorRepository;

    public static void main(String[] args) {
        SpringApplication.run(MrXavierApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {}
}