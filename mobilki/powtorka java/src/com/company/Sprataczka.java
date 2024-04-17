package com.company;

import java.util.ArrayList;

public class Sprataczka implements Pracownik{
    private String imie;
    private String nawisko;
    private String adres;
    private double wyplata;
    private ArrayList<String> ostrerzenia;

    public Sprataczka(String imie, String nawisko, String adres, double wyplata, ArrayList<String> ostrerzenia) {
        this.imie = imie;
        this.nawisko = nawisko;
        this.adres = adres;
        this.wyplata = wyplata;
        this.ostrerzenia = ostrerzenia;
    }

    @Override
    public void przyznajPremie(double kwota) {
        wyplata+=kwota;
    }

    @Override
    public double obliczNetto() {
        return wyplata*0.77;
    }

    @Override
    public void dodajOstrzezenie(String tresc) {
        ostrerzenia.add(tresc);
    }

    @Override
    public void przyznajKare(double kwota) {
        wyplata-=kwota;
    }
}
