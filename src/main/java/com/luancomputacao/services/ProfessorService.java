package com.luancomputacao.services;

import com.luancomputacao.domain.Professor;
import com.luancomputacao.repository.ProfessorRepository;
import com.luancomputacao.utils.CpfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    /**
     * Avalia se o Nome é válido
     * <p>
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
        return CpfUtils.isCPF(cpf);
    }

    /**
     * Avalia se a senha obedece os padrões de segurança requeridos
     * <p>
     * Deve conter
     * - maiúsculas
     * - minúsculas
     * - algum dos caracteres ._@#$%^&+=
     * - 8 dígitos ou mais
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
     * @param cpf   CPF para validação
     * @param nome  Nome do Professor para validação
     * @param senha Senha do Professor para validação
     * @return Verdadeiro se todos os dados forem validos
     */
    Boolean verificaDados(String cpf, String nome, String senha) {
        return (this.validaCpf(cpf) && this.validaNome(nome) && this.validaSenha(senha));
    }


    /**
     * Cria um Professor do tipo Moderador
     *
     * @param cpf   CPF para o Professor
     * @param nome  Nome para o Professor
     * @param senha Senha para o Professor
     * @return Novo objeto do tipo professor ou nulo se falhar
     */
    public Professor criarModerador(String cpf, String nome, String senha) {
        if (verificaDados(cpf, nome, senha)) {
            Professor professor = new Professor(cpf, nome, senha, true);
            return professorRepository.save(professor);
        }
        return null;
    }

    /**
     * Cria um Professor não moderador
     *
     * @param cpf   CPF para o Professor
     * @param nome  Nome para o Professor
     * @param senha Senha para o Professor
     * @return Novo objeto do tipo professor ou nulo se falhar
     */
    public Professor criarProfessor(String cpf, String nome, String senha) {
        if (verificaDados(cpf, nome, senha)) {
            Professor professor = new Professor(cpf, nome, senha, false);
            return professorRepository.save(professor);
        }
        return null;
    }


    public Professor encontrar(Integer id) {
        return professorRepository.findById(id).orElse(null);
    }

    /**
     * Lista todos os professores
     *
     * @return Lista de Professores
     */
    public List<Professor> listar() {
        return professorRepository.findAll();
    }
}
