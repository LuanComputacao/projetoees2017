package com.luancomputacao.domain;

public enum  TipoDeQuestao{
    DISCURSIVA(1), OBJETIVA(2);

    private int tipoDeQuestao;

    TipoDeQuestao(int i) {
        tipoDeQuestao = i;
    }
}
