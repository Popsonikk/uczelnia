package com.company;

public class Obligacje extends  Papieryw{
    public  float  oprocentowanie;

    public Obligacje(float wartosc, int id, float oprocentowanie) {
        super(wartosc, id);
        this.oprocentowanie = oprocentowanie;
    }

    @Override
    public void step() {
        setWartosc(getWartosc()*oprocentowanie);
    }
}
