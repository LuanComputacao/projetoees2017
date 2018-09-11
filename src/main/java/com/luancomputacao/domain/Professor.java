package com.luancomputacao.domain;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="professor")
@EntityListeners(AuditingEntityListener.class)
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", length = 11)
    private Integer id;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "nome", length = 128)
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
