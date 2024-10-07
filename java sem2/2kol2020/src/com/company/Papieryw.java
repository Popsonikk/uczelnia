package com.company;

public abstract class Papieryw {
    private float wartosc;
    private  int id;

    public void setWartosc(float wartosc) {
        this.wartosc = wartosc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Papieryw(float wartosc, int id) {
        this.wartosc = wartosc;
        this.id = id;
    }

    public float getWartosc() {
        return wartosc;
    }

    public abstract  void step();
}
