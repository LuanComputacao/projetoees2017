package com.luancomputacao.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="opcao_de_questao")
@EntityListeners(AuditingEntityListener.class)
public class OpcaoDeQuestao implements Serializable {
    private String texto;

    public OpcaoDeQuestao() {
    }


    public OpcaoDeQuestao(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpcaoDeQuestao that = (OpcaoDeQuestao) o;
        return Objects.equals(getTexto(), that.getTexto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTexto());
    }


    @Override
    public String toString() {
        return "OpcaoDeQuestao{" +
                "texto='" + texto + '\'' +
                '}';
    }
}
