package com.luancomputacao.domain;

import java.util.Objects;

public class FaseDeEnsino {
    private String nome;

    public FaseDeEnsino() {
    }

    public FaseDeEnsino(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FaseDeEnsino that = (FaseDeEnsino) o;
        return Objects.equals(getNome(), that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    @Override
    public String toString() {
        return "FaseDeEnsino{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
