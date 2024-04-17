package com.company;

import java.util.ArrayList;

public class KierownikMarketingu extends Kierownictwo{
    Boolean Samochod;
    String numerRejestracyjny;
    String numerSluzbowy;
    ArrayList<String> klienci;

    public KierownikMarketingu(String imie, String nazwisko, String adres, double wyplata, Boolean samochod, String numerRejestracyjny, String numerSluzbowy, ArrayList<String> klienci) {
        super(imie, nazwisko, adres, wyplata);
        Samochod = samochod;
        this.numerRejestracyjny = numerRejestracyjny;
        this.numerSluzbowy = numerSluzbowy;
        this.klienci = klienci;
    }

    @Override
    void ustalWyplatę(double kwota) {
        setWyplata(kwota);
    }

    @Override
    void wyswietlInfo() {
        if(Samochod)
            System.out.println("imie "+ imie+' '+nazwisko+" adres "+adres+" wyplata "+wyplata+" samochod "+numerRejestracyjny);
         else
             System.out.println("imie "+ imie+' '+nazwisko+" adres "+adres+" wyplata "+wyplata);
    }

    @Override
    void liczPremie() {
        setWyplata(wyplata+klienci.size()*10);
    }
    void nadajAuto(String numerRejestracyjny)
    {
        this.numerRejestracyjny=numerRejestracyjny;
        this.Samochod=true;
    }
    void dodajKlienta(String nazwa)
    {
        klienci.add(nazwa);

    }
    void usunKlienta(String nazwa)
    {
        klienci.remove(nazwa);

    }
}
