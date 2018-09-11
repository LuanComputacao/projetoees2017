package com.luancomputacao.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="materia")
@EntityListeners(AuditingEntityListener.class)
public class Materia implements Serializable {
    private Disciplina disciplina;
    private String nome;

    public Materia() {
        this.disciplina = disciplina;
    }

    public Materia(Disciplina disciplina, String nome) {
        this.disciplina = disciplina;
        this.nome = nome;
    }


    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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
        Materia materia = (Materia) o;
        return Objects.equals(getDisciplina(), materia.getDisciplina()) &&
                Objects.equals(getNome(), materia.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDisciplina(), getNome());
    }


    @Override
    public String toString() {
        return "Materia{" +
                "disciplina=" + disciplina +
                ", nome='" + nome + '\'' +
                '}';
    }
}
