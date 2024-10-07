package com.company;

public class Trójkąt extends  Figura{
    public Trójkąt(int a, int b, int h) {
        super(a, b, h);
    }

    @Override
    public int getA() {
        return super.getA();
    }

    @Override
    public int getB() {
        return super.getB();
    }

    @Override
    public int getH() {
        return super.getH();
    }

    @Override
    int pole() {
        return (getA()*getH())/2;
    }
}
