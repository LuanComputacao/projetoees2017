package com.luancomputacao.services;

import com.luancomputacao.domain.Disciplina;
import com.luancomputacao.domain.Materia;
import com.luancomputacao.domain.Professor;
import com.luancomputacao.domain.enums.Perfil;
import com.luancomputacao.repository.DisciplinaRepository;
import com.luancomputacao.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBTestService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public void instantiateTestDataBase()  throws ParseException {

        Professor professor1 = new Professor("21817061070", "Nome1", passwordEncoder.encode("123"), Boolean.TRUE);
        professor1.addPerfil(Perfil.ADMIN);
        Professor professor2 = new Professor("94549727071", "Nome2", passwordEncoder.encode("123"), Boolean.TRUE);
        professor2.addPerfil(Perfil.MODERADOR);
        Professor professor3 = new Professor("06047128041", "Nome3", passwordEncoder.encode("123"), Boolean.TRUE);

        professorRepository.saveAll(Arrays.asList(
                professor1,
                professor2,
                professor3
        ));


        Disciplina disciplina1 = new Disciplina("Matemática");
        Disciplina disciplina2 = new Disciplina("Português");

        disciplinaRepository.saveAll(Arrays.asList(
                disciplina1,
                disciplina2
        ));


        Materia materia1 = new Materia(disciplina1, "Funções");
        Materia materia2 = new Materia(disciplina1, "Funções Compostas");
        Materia materia3 = new Materia(disciplina2, "Funções Compostas");
        Materia materia4 = new Materia(disciplina2, "Funções Compostas");


    }
}
