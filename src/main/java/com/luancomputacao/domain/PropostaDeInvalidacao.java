package com.luancomputacao.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "proposta_de_invalidacao")
@EntityListeners(AuditingEntityListener.class)
public class PropostaDeInvalidacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name = "id_questao", referencedColumnName = "id", updatable = false, nullable = false)
    private Questao questao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name = "id_professor", referencedColumnName = "id", updatable = false, nullable = false)
    private Professor professor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinColumn(name = "id_moderador", referencedColumnName = "id", updatable = false, nullable = false)
    private Professor moderador;


    @Column(name = "criado_em", updatable = false)
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date dataPostagem;

    @Column(name = "analisado_em", updatable = false)
    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    private Date dataAnalise;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "justificativa", nullable = false)
    private String justificativa;

    @Column(name = "proposta", nullable = false)
    private String proposta;

    public PropostaDeInvalidacao(Questao questao, Professor professor, Professor moderador) {
        this.questao = questao;
        this.professor = professor;
        this.moderador = moderador;
    }

    public PropostaDeInvalidacao(Questao questao, Professor professor, Professor moderador, String justificativa, String proposta) {
        this.questao = questao;
        this.professor = professor;
        this.moderador = moderador;
        this.justificativa = justificativa;
        this.proposta = proposta;
    }


    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getModerador() {
        return moderador;
    }

    public void setModerador(Professor moderador) {
        this.moderador = moderador;
    }

    public Date getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(Date dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    public Date getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Date dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getProposta() {
        return proposta;
    }

    public void setProposta(String proposta) {
        this.proposta = proposta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropostaDeInvalidacao that = (PropostaDeInvalidacao) o;
        return Objects.equals(getQuestao(), that.getQuestao()) &&
                Objects.equals(getProfessor(), that.getProfessor()) &&
                Objects.equals(getModerador(), that.getModerador()) &&
                Objects.equals(getDataPostagem(), that.getDataPostagem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestao(), getProfessor(), getModerador(), getDataPostagem());
    }

    @Override
    public String toString() {
        return "PropostaDeInvalidacao{" +
                "questao=" + questao +
                ", professor=" + professor +
                ", moderador=" + moderador +
                ", dataAnalise=" + dataAnalise +
                ", dataPostagem=" + dataPostagem +
                ", status=" + status +
                ", justificativa='" + justificativa + '\'' +
                ", proposta='" + proposta + '\'' +
                '}';
    }
}
