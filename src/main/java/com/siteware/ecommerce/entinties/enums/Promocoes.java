package com.siteware.ecommerce.entinties.enums;

public enum Promocoes {


    NENHUMA_PROMOCAO(0),
    LEVE_2_PAGUE_1(1),
    TRES_POR_DEZ(2);

    private int code;

    private Promocoes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Promocoes valeuOf(int code) {
        for (Promocoes value : Promocoes.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Promocoes code");
    }
}
