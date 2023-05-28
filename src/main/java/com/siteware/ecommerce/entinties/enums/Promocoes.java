package com.siteware.ecommerce.entinties.enums;

public enum Promocoes {
    TRES_POR_DEZ(0),
    LEVE_2_PAGUE_1(1),
    NENHUMA_PROMOCAO(2);

    private int code;

    private Promocoes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Promocoes valeuOf(int code) {
        for(Promocoes valeu : Promocoes.values()){
            if (valeu.getCode() == code){
                return valeu;
            }
        }
        throw new IllegalArgumentException("Invalid Promocoes code");
    }
}
