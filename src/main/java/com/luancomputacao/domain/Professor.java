package com.luancomputacao.domain;

import java.util.Objects;

public class Professor {
    private String cpf;
    private String nome;
    private String senha;
    private Boolean moderador;

    public Professor() { }

    public Professor(String cpf, String nome, String senha, Boolean moderador) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.moderador = moderador;
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
        Professor professor = (Professor) o;
        return Objects.equals(getCpf(), professor.getCpf()) &&
                Objects.equals(getModerador(), professor.getModerador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf(), getModerador());
    }

    @Override
    public String toString() {
        return "Professor{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", moderador=" + moderador +
                '}';
    }
}
