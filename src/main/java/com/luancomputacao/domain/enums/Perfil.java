package com.luancomputacao.domain.enums;

public enum Perfil {
    ADMIN(1, "ROLE_ADMIN"),
    PROFESSOR(2, "ROLE_CLIENTE"),
    MODERADOR(3, "ROLE_CLIENTE")
    ;

    private int cod;
    private String descricao;

    Perfil(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum(Integer cod) throws IllegalAccessException {
        if (cod == null) {
            return null;
        }

        for (Perfil x : Perfil.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalAccessException("Id invalido: " + cod);
    }
}
