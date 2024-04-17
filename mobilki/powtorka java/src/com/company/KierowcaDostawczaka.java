package com.company;

import java.util.ArrayList;

public class KierowcaDostawczaka implements Pracownik,Kierowca{
    private String imie;
    private String nawisko;
    private String adres;
    private double wyplata;
    private ArrayList<String> ostrerzenia;
    private String rodzajsamochodu;
    private int numersamochodu;
    private String rodzajPrawaJazdy;
    private boolean badania;

    public KierowcaDostawczaka(String imie, String nawisko, String adres, double wyplata, ArrayList<String> ostrerzenia, String rodzajsamochodu, int numersamochodu, String rodzajPrawaJazdy,boolean badania) {
        this.imie = imie;
        this.nawisko = nawisko;
        this.adres = adres;
        this.wyplata = wyplata;
        this.ostrerzenia = ostrerzenia;
        this.rodzajsamochodu = rodzajsamochodu;
        this.numersamochodu = numersamochodu;
        this.rodzajPrawaJazdy = rodzajPrawaJazdy;
        this.badania=badania;
    }

    @Override
    public void nadajPojazd(String nazwa, int numer) {
        this.rodzajsamochodu=nazwa;
        this.numersamochodu=numer;
    }

    @Override
    public boolean sprawdzBadanieTechniczne() {
        return badania;
    }

    @Override
    public void wyswietlInformacje() {
        System.out.println("Imie "+imie+" nazwisko "+nawisko+ " dane samochodu "+ rodzajsamochodu+' '+numersamochodu);
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
