package com.company;

import java.util.ArrayList;

public class OperatorPily implements  Pracownik,PracownikHali{
    private String imie;
    private String nawisko;
    private String adres;
    private double wyplata;
    private ArrayList<String> ostrerzenia;
    private String rodajMasyny;
    private int numerstanowiska;
    private boolean badania;

    public OperatorPily(String imie, String nawisko, String adres, double wyplata, ArrayList<String> ostrerzenia, String rodajMasyny, int numerstanowiska, boolean badania) {
        this.imie = imie;
        this.nawisko = nawisko;
        this.adres = adres;
        this.wyplata = wyplata;
        this.ostrerzenia = ostrerzenia;
        this.rodajMasyny = rodajMasyny;
        this.numerstanowiska = numerstanowiska;
        this.badania = badania;
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

    @Override
    public void nadajStanowsiko() {
        this.numerstanowiska=numerstanowiska;
    }

    @Override
    public boolean sprawdzBadaniaLekarskie() {
        return badania;
    }

    @Override
    public void sprawdzAkord() {

    }



    @Override
    public void WyswietlInfo() {
        System.out.println(imie+nawisko+adres+wyplata);

    }
}
