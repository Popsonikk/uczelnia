package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class LosowaLista extends Lista{
    private static int najwieksza;
    private static int najmniejsza;
    private static int suma;
    private static double srednia;


    public LosowaLista() {
        for(int i=0;i<100;i++)
            dodaj_tyl((int)(Math.random()*200));
        najwieksza=0;
        najmniejsza=0;
        suma=0;
        srednia=0;
    }
    static void licz_srednia(ArrayList<Integer> list)
    {
        srednia=0;
        for(int i=0;i<100;i++)
        {
            srednia+=list.get(i);
        }
        srednia/=100;
    }
    static void licz_sume(ArrayList<Integer> list)
    {
        suma=0;
        for(int i=0;i<100;i++)
        {
            suma+=list.get(i);
        }
    }
    static void licz_najwieksza(ArrayList<Integer> list)
    {
        najwieksza=list.get(0);
        for(int i=1;i<100;i++)
        {
            if(najwieksza<list.get(i))
                najwieksza=list.get(i);
        }

    }
    static void licz_najmniejsza(ArrayList<Integer> list)
    {
        najmniejsza=list.get(0);
        for(int i=1;i<100;i++)
        {
            if(najmniejsza>list.get(i))
                najmniejsza=list.get(i);
        }

    }
    static void wyswietl_info()
    {
        System.out.println("suma="+suma);
        System.out.println("srednia="+srednia);
        System.out.println("najwieksza="+najwieksza);
        System.out.println("najmniejsza="+najmniejsza);
    }



}
