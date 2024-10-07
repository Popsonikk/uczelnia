package com.company;

public  abstract class Figura {
    private int a;
    private int b;
    private int h;

    public Figura(int a, int b, int h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getH() {
        return h;
    }

    abstract int pole();
}
