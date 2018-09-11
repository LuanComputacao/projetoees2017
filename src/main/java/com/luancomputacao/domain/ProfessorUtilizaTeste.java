package com.luancomputacao.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="professor_utiliza_teste")
@EntityListeners(AuditingEntityListener.class)
public class ProfessorUtilizaTeste implements Serializable {
    private Professor professor;
    private Teste teste;
    private Date dataUtilizacao;

    public ProfessorUtilizaTeste(Professor professor, Teste teste) {
        this.professor = professor;
        this.teste = teste;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Teste getTeste() {
        return teste;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }

    public Date getDataUtilizacao() {
        return dataUtilizacao;
    }

    public void setDataUtilizacao(Date dataUtilizacao) {
        this.dataUtilizacao = dataUtilizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorUtilizaTeste that = (ProfessorUtilizaTeste) o;
        return Objects.equals(getProfessor(), that.getProfessor()) &&
                Objects.equals(getTeste(), that.getTeste()) &&
                Objects.equals(getDataUtilizacao(), that.getDataUtilizacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProfessor(), getTeste(), getDataUtilizacao());
    }

    @Override
    public String toString() {
        return "ProfessorUtilizaTeste{" +
                "professor=" + professor +
                ", teste=" + teste +
                ", dataUtilizacao=" + dataUtilizacao +
                '}';
    }
}
