package com.luancomputacao.resource.forms;


import com.luancomputacao.constraint.ValidPassword;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProfessorForm {

    @NotNull(message = "CPF cannot be null")

    private String cpf;

    @NotNull
    @Min(2)
    private String nome;

    @NotNull
    @ValidPassword
    private String senha;

    @NotNull
    private Boolean moderador;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getModerador() {
        return moderador;
    }

    public void setModerador(Boolean moderador) {
        this.moderador = moderador;
    }

    @Override
    public String toString() {
        return "ProfessorForm{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", moderador=" + moderador +
                '}';
    }
}
