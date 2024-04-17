package com.company;

public class Student {
    private String imie;
    private String nawisko;
    private String adres;
    private int  numerAlbumu;
    private double sredniaOcen;

    public Student(String imie, String nawisko, String adres, int numerAlbumu) {
        this.imie = imie;
        this.nawisko = nawisko;
        this.adres = adres;
        this.numerAlbumu = numerAlbumu;
    }
    public void obliczSrednia(double[] arr)
    {
        double suma=0;
        for(int i=0;i< arr.length;i++)
            suma+=arr[i];
        this.sredniaOcen=suma/ arr.length;
    }
    void wyswieltInfo()
    {
        System.out.println("imie "+imie+" nawisko "+nawisko
        +" adres "+adres + " indeks "+numerAlbumu + " srednia "+ sredniaOcen);
    }

    public int getNumerAlbumu() {
        return numerAlbumu;
    }

    public void setSredniaOcen(double sredniaOcen) {
        this.sredniaOcen = sredniaOcen;
    }
}
