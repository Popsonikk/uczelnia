package com.company;

public class LepszyStudent extends Student{
    public LepszyStudent(String imie, String nawisko, String adres, int numerAlbumu) {
        super(imie, nawisko, adres, numerAlbumu);
    }
    public void obliczSrednia(double[] arr)
    {
        double suma=0;
        for (double v : arr) suma += v;
        suma/= arr.length;

         if (suma-(double)Math.round(suma)<0)
            suma=(double)Math.round(suma);
        else if(suma-(double)Math.round(suma)<=0.5)
            suma=(double)Math.round(suma)+0.5;
        setSredniaOcen(suma);
    }
}
