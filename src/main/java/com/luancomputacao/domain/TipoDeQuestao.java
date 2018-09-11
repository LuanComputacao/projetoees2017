package com.luancomputacao.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="tipo_de_questao")
@EntityListeners(AuditingEntityListener.class)
public enum  TipoDeQuestao implements Serializable {
    DISCURSIVA(1), OBJETIVA(2);

    private int tipoDeQuestao;

    TipoDeQuestao(int i) {
        tipoDeQuestao = i;
    }
}
