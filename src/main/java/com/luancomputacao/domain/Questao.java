package com.luancomputacao.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="questao")
@EntityListeners(AuditingEntityListener.class)
public class Questao implements Serializable {
    private Date criadoEm;
    private Date atualizadoEm;
    private Professor autor;
    private Disciplina disciplina;
    private String enunciado;
    private Integer espacos;
    private FaseDeEnsino faseDeEnsino;
    private Boolean invalidada;
    private Collection<Materia> materias;
    private Float nivel;
    private Collection<OpcaoDeQuestao> opcoesDeQuestao;
    private Boolean publica;
    private Enum<TipoDeQuestao> tipoDeQuestaoEnum;

    public Questao(Professor autor, Disciplina disciplina, Collection<Materia> materias, Enum<TipoDeQuestao> tipoDeQuestaoEnum) {
        this.autor = autor;
        this.disciplina = disciplina;
        this.materias = materias;
        this.tipoDeQuestaoEnum = tipoDeQuestaoEnum;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Date getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(Date atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public Professor getAutor() {
        return autor;
    }

    public void setAutor(Professor autor) {
        this.autor = autor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Integer getEspacos() {
        return espacos;
    }

    public void setEspacos(Integer espacos) {
        this.espacos = espacos;
    }

    public FaseDeEnsino getFaseDeEnsino() {
        return faseDeEnsino;
    }

    public void setFaseDeEnsino(FaseDeEnsino faseDeEnsino) {
        this.faseDeEnsino = faseDeEnsino;
    }

    public Boolean getInvalidada() {
        return invalidada;
    }

    public void setInvalidada(Boolean invalidada) {
        this.invalidada = invalidada;
    }

    public Collection<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Collection<Materia> materias) {
        this.materias = materias;
    }

    public Float getNivel() {
        return nivel;
    }

    public void setNivel(Float nivel) {
        this.nivel = nivel;
    }

    public Collection<OpcaoDeQuestao> getOpcoesDeQuestao() {
        return opcoesDeQuestao;
    }

    public void setOpcoesDeQuestao(Collection<OpcaoDeQuestao> opcoesDeQuestao) {
        this.opcoesDeQuestao = opcoesDeQuestao;
    }

    public Boolean getPublica() {
        return publica;
    }

    public void setPublica(Boolean publica) {
        this.publica = publica;
    }

    public Enum<TipoDeQuestao> getTipoDeQuestaoEnum() {
        return tipoDeQuestaoEnum;
    }

    public void setTipoDeQuestaoEnum(Enum<TipoDeQuestao> tipoDeQuestaoEnum) {
        this.tipoDeQuestaoEnum = tipoDeQuestaoEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questao questao = (Questao) o;
        return Objects.equals(getCriadoEm(), questao.getCriadoEm()) &&
                Objects.equals(getAutor(), questao.getAutor()) &&
                Objects.equals(getDisciplina(), questao.getDisciplina()) &&
                Objects.equals(getFaseDeEnsino(), questao.getFaseDeEnsino()) &&
                Objects.equals(getPublica(), questao.getPublica());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCriadoEm(), getAutor(), getDisciplina(), getFaseDeEnsino(), getPublica());
    }


    @Override
    public String toString() {
        return "Questao{" +
                "criadoEm=" + criadoEm +
                ", atualizadoEm=" + atualizadoEm +
                ", autor=" + autor +
                ", disciplina=" + disciplina +
                ", enunciado='" + enunciado + '\'' +
                ", espacos=" + espacos +
                ", faseDeEnsino=" + faseDeEnsino +
                ", invalidada=" + invalidada +
                ", materias=" + materias +
                ", nivel=" + nivel +
                ", opcoesDeQuestao=" + opcoesDeQuestao +
                ", publica=" + publica +
                ", tipoDeQuestaoEnum=" + tipoDeQuestaoEnum +
                '}';
    }
}
