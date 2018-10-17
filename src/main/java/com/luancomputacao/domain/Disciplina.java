package com.luancomputacao.domain;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "disciplina")
@EntityListeners(AuditingEntityListener.class)
@JsonRootName(value = "disciplina")
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    @Length(max = 128)
    private String nome;

    @OneToMany(mappedBy = "disciplina", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Collection<Materia> materias;

    @OneToMany(mappedBy = "disciplina")
    @JsonBackReference
    private Collection<Questao> questoes;

    @OneToMany(mappedBy = "disciplina")
    @JsonBackReference
    private Collection<Teste> testes;

    public Disciplina() {
    }

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Collection<Materia> materias) {
        this.materias = materias;
    }

    public Collection<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(Collection<Questao> questoes) {
        this.questoes = questoes;
    }

    public Collection<Teste> getTestes() {
        return testes;
    }

    public void setTestes(Collection<Teste> testes) {
        this.testes = testes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(getNome(), that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
