package com.luancomputacao.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "fase_de_ensino ")
@EntityListeners(AuditingEntityListener.class)
public class FaseDeEnsino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "faseDeEnsino")
    @JsonBackReference
    private Collection<Questao> questoes;


    @OneToMany(mappedBy = "faseDeEnsino")
    @JsonBackReference
    private Collection<Teste> testes;


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
