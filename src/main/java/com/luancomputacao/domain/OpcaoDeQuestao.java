package com.luancomputacao.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "opcao_de_questao")
@EntityListeners(AuditingEntityListener.class)
public class OpcaoDeQuestao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_questao", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Questao questao;

    @Column(name = "texto")
    private String texto;

    @Column(name = "value")
    private Boolean value;

    public OpcaoDeQuestao() {
    }

    public OpcaoDeQuestao(Questao questao, String texto, Boolean value) {
        this.questao = questao;
        this.texto = texto;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
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
