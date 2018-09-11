package com.luancomputacao.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="teste")
@EntityListeners(AuditingEntityListener.class)
public class Teste implements Serializable {
    private String descricao;
    private Professor autor;
    private Date criadoEm;
    private Date atualizadoEm;
    private FaseDeEnsino faseDeEnsino;
    private Disciplina disciplina;
    private Collection<Questao> questoes;
}
