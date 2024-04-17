package com.company;

public class KierownikMontażu extends Kierownictwo{

  int godzinyPonadNorme;
    boolean wyrobionaNorma;

    public KierownikMontażu(String imie, String nazwisko, String adres, double wyplata, int godzinyPonadNorme, boolean wyrobionaNorma) {
        super(imie, nazwisko, adres, wyplata);
        this.godzinyPonadNorme = godzinyPonadNorme;
        this.wyrobionaNorma = wyrobionaNorma;
    }

    @Override
    void ustalWyplatę(double kwota) {
        setWyplata(kwota);
    }

    @Override
    void wyswietlInfo() {
        System.out.println("imie "+ imie+' '+nazwisko+" adres "+adres+" wyplata "+wyplata);
    }

    @Override
    void liczPremie() {
        double bonus=0;
        if(wyrobionaNorma)
            bonus= godzinyPonadNorme*10;
        setWyplata(wyplata+bonus);

    }
}
