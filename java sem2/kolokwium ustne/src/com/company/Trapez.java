package com.company;

public class Trapez extends Figura{
    public Trapez(int a, int b, int h) {
        super(a, b, h);
    }

    @Override
    int pole() {
        return (getA()+getB())*getH()/2;
    }
}
