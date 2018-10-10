package com.luancomputacao.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luancomputacao.domain.enums.Perfil;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "professor")
@EntityListeners(AuditingEntityListener.class)
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "nome", length = 128)
    private String nome;

    @Column(name = "senha")
    @JsonIgnore
    private String senha;

    @Column(name = "moderador")
    private Boolean moderador;

    @OneToMany(mappedBy = "autor")
    @JsonBackReference
    private Collection<Questao> questoes;

    @OneToMany(mappedBy = "teste")
    @JsonBackReference
    private Collection<ProfessorUtilizaTeste> professorUtilizaTestes;

    @OneToMany(mappedBy = "professor")
    @JsonBackReference
    private Collection<PropostaDeInvalidacao> propostasDeInvalidacao;

    @OneToMany(mappedBy = "moderador")
    @JsonBackReference
    private Collection<PropostaDeInvalidacao> propostasDeInvalidacaoModeradas;

    @OneToMany(mappedBy = "autor")
    @JsonBackReference
    private Collection<Teste> testes;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    public Professor() {
        addPerfil(Perfil.PROFESSOR);
    }

    public Professor(String cpf, String nome, String senha, Boolean moderador) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.moderador = moderador;
        addPerfil(Perfil.PROFESSOR);
    }

    private static Perfil perfilEnum(Integer x) {
        try {
            return Perfil.toEnum(x);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
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

    public Collection<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(Collection<Questao> questoes) {
        this.questoes = questoes;
    }

    public Set<Perfil> getPerfil(){
        return this.perfis.stream().map(Professor::perfilEnum).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil.getCod());
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
