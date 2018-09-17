package com.luancomputacao;

import com.luancomputacao.domain.*;
import com.luancomputacao.repository.ProfessorRepository;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class MrXavierApplication implements CommandLineRunner {

    @Autowired
    ProfessorRepository professorRepository;

    public static void main(String[] args) {
        SpringApplication.run(MrXavierApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Professor professor1 = new Professor("01929283847", "Nome", "Aaaa.1234", false);
        Professor professor2 = new Professor("93845763892", "Nome", "Aaaa.1234", false);

        professorRepository.saveAll(Arrays.asList(professor1, professor2));
    }
}