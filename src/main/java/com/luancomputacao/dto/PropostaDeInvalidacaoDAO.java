package com.luancomputacao.dto;

import java.util.Objects;

public class PropostaDeInvalidacaoDAO {
    private Integer questaoID;
    private String proposta;
    private String justificativa;
    private Integer professorID;

    public Integer getQuestaoID() {
        return questaoID;
    }

    public void setQuestaoID(Integer questaoID) {
        this.questaoID = questaoID;
    }

    public String getProposta() {
        return proposta;
    }

    public void setProposta(String proposta) {
        this.proposta = proposta;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public Integer getProfessorID() {
        return professorID;
    }

    public void setProfessorID(Integer professorID) {
        this.professorID = professorID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropostaDeInvalidacaoDAO that = (PropostaDeInvalidacaoDAO) o;
        return Objects.equals(getQuestaoID(), that.getQuestaoID()) &&
                Objects.equals(getProposta(), that.getProposta()) &&
                Objects.equals(getJustificativa(), that.getJustificativa()) &&
                Objects.equals(getProfessorID(), that.getProfessorID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestaoID(), getProposta(), getJustificativa(), getProfessorID());
    }
}
