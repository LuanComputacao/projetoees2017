package com.luancomputacao.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="fase_de_ensino ")
@EntityListeners(AuditingEntityListener.class)
public class FaseDeEnsino implements Serializable {
    private String nome;

    public FaseDeEnsino() {
    }

    public FaseDeEnsino(String nome) {
        this.nome = nome;
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
        FaseDeEnsino that = (FaseDeEnsino) o;
        return Objects.equals(getNome(), that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    @Override
    public String toString() {
        return "FaseDeEnsino{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
