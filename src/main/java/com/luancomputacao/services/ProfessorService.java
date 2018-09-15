package com.luancomputacao.services;

import com.luancomputacao.domain.Professor;
import com.luancomputacao.repository.ProfessorRepository;
import com.luancomputacao.utils.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final
    ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    /**
     * Avalia se o Nome é válido
     *
     * - mais de um caractere válido
     *
     * @param nome Nome para avaliação
     * @return Verdadeiro se válido
     */
    Boolean validaNome(String nome) {
        return nome.length() > 1;
    }

    /**
     * Verifica se o CPF é válido ou não
     *
     * @param cpf CPF para ser avaliado
     * @return Verdadeiro se válido
     */
    Boolean validaCpf(String cpf) {
        return CPF.isCPF(cpf);
    }

    /**
     * Avalia se a senha obedece os padrões de segurança requeridos
     *
     * Deve conter
     *  - maiúsculas
     *  - minúsculas
     *  - algum dos caracteres .@#$%^&+=
     *  - 8 dígitos ou mais
     *
     * @param senha Senha para validação
     * @return Verdadeiro se válida
     */
    Boolean validaSenha(String senha) {
        return (senha.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[._@#$%^&+=])(?=\\S+$).{8,}$"));
    }


    /**
     * Verifica se os dados são validos para a criação do Professor
     *
     * @param cpf CPF para validação
     * @param nome Nome do Professor para validação
     * @param senha Senha do Professor para validação
     * @return Verdadeiro se todos os dados forem validos
     */
    Boolean verificaDados(String cpf, String nome, String senha) {
        return (this.validaCpf(cpf) && this.validaNome(nome) && this.validaSenha(senha));
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
