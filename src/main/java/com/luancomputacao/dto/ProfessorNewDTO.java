package com.luancomputacao.dto;

import com.luancomputacao.domain.Professor;

import java.util.Objects;

public class ProfessorNewDTO {
    private String cpf;
    private String nome;
    private String senha;
    private Boolean moderador;

    public ProfessorNewDTO() {

    }

    public ProfessorNewDTO(Professor professor) {
        this.nome = professor.getNome();
        this.cpf = professor.getCpf();
    }


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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorDTO that = (ProfessorDTO) o;
        return Objects.equals(getCpf(), that.getCpf()) &&
                Objects.equals(getNome(), that.getNome());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCpf(), getNome());
    }

    @Override
    public String toString() {
        return "ProfessorDTO{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
