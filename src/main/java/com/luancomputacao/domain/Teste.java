package com.luancomputacao.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "teste")
@EntityListeners(AuditingEntityListener.class)
public class Teste implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    private Professor autor;

    @Column(name = "criado_em", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date criadoEm;

    @Column(name = "atualizado_em")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date atualizadoEm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name = "id_fase_de_ensino", referencedColumnName = "id")
    private FaseDeEnsino faseDeEnsino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id")
    private Disciplina disciplina;

    @ManyToMany
    @JoinTable(
            name = "materia_de_questao",
            joinColumns = {@JoinColumn(name = "questao_id")},
            inverseJoinColumns = {@JoinColumn(name = "materia_id")}
    )
    @JsonBackReference("testes")
    private Collection<Questao> questoes;

    @OneToMany(mappedBy = "teste")
    @JsonBackReference
    private Collection<ProfessorUtilizaTeste> professorUtilizaTestes;

    public Teste(String descricao, Professor autor, FaseDeEnsino faseDeEnsino, Disciplina disciplina, Collection<Questao> questoes) {
        this.descricao = descricao;
        this.autor = autor;
        this.faseDeEnsino = faseDeEnsino;
        this.disciplina = disciplina;
        this.questoes = questoes;
    }
}
