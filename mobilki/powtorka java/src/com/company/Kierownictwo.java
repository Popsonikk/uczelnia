package com.company;

public abstract class Kierownictwo {
    String imie;
    String nazwisko;
    String adres;
    double wyplata;
    public Kierownictwo(String imie, String nazwisko, String adres, double wyplata) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.wyplata = wyplata;
    }

    public void setWyplata(double wyplata) {
        this.wyplata = wyplata;
    }

    abstract void ustalWyplatę(double kwota);
    abstract void wyswietlInfo();
    abstract void liczPremie();

}
