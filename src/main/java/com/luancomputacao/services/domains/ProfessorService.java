package com.luancomputacao.services.domains;

import com.luancomputacao.domain.Professor;
import com.luancomputacao.domain.enums.Perfil;
import com.luancomputacao.repository.ProfessorRepository;
import com.luancomputacao.security.UserSS;
import com.luancomputacao.utils.CpfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private BCryptPasswordEncoder bc;

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
        return CpfUtil.isCPF(cpf);
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

    public Professor criarProfessor(String cpf, String nome, String senha, boolean moderador) {
        return moderador ? this.criarModerador(cpf, nome, senha) : this.criarProfessorComum(cpf, nome, senha);
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
            Professor professor = new Professor(cpf, nome, bc.encode(senha), true);
            professor.addPerfil(Perfil.MODERADOR);
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
    public Professor criarProfessorComum(String cpf, String nome, String senha) {
        if (verificaDados(cpf, nome, senha)) {
            Professor professor = new Professor(cpf, nome, bc.encode(senha), false);
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

    public Professor encontrarPorCPF(String cpf) {
        return professorRepository.findByCpf(cpf);
    }


    public UserSS obterUserSS(String authenticatedUser) {
        Professor professor = professorRepository.findOneByCpf(authenticatedUser);
        return professor != null ? new UserSS(professor) : null;
    }

    public Boolean eProfessor(UserSS userSS) {
        return userSS != null && userSS.hasRole(Perfil.PROFESSOR);
    }

    public Boolean eModerador(UserSS userSS) {
        return userSS != null && userSS.hasRole(Perfil.MODERADOR);
    }
}
