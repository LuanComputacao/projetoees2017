package com.luancomputacao.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "materia")
@EntityListeners(AuditingEntityListener.class)
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonManagedReference
    private Disciplina disciplina;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "materias")
    private Collection<Questao> questoes;

    public Materia() {
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
