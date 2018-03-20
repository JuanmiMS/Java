package org.mvpigs;

public enum RomanEnum {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int valorDecimal;

    private RomanEnum(int valor){
        this.valorDecimal = valor;
    }
    public int getNum(){
        return this.valorDecimal;
    }
}