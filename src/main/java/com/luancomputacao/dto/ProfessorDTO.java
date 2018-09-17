package com.luancomputacao.dto;

import com.luancomputacao.domain.Professor;

import java.util.Objects;

public class ProfessorDTO {
    private String cpf;
    private String nome;

    public ProfessorDTO() {

    }

    public ProfessorDTO(Professor professor) {
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
