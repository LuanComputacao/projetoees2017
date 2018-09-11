package com.luancomputacao.services;

import com.luancomputacao.domain.Professor;
import com.luancomputacao.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    private Boolean verificaDados(String cpf, String nome, String senha) {
        Boolean valido = true;

        // CPF
        if (cpf.equals("") || cpf.length() < 11) valido = false;

        // Nome
        if (nome.equals("") || nome.length() < 2) valido = false;

        // Senha
        if (!(senha.equals("") || senha.matches("\"^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$\"")))
            valido = false;

        return valido;
    }


    public Boolean realizarLogin() {
        return true;
    }

    public Professor criarModerador(String cpf, String nome, String senha) {
        if (verificaDados(cpf, nome, senha)) {
            Professor professor = new Professor(cpf, nome, senha, true);
            return professorRepository.save(professor);
        }
        return null;
    }

    public Professor criarProfessor(String cpf, String nome, String senha) {
        if (verificaDados(cpf, nome, senha)) {
            Professor professor = new Professor(cpf, nome, senha, false);
            return professorRepository.save(professor);
        }
        return null;
    }
}
