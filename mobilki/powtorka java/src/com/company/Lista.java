package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Lista {
    ArrayList<Integer> lista;
    Scanner scanner = new Scanner(System.in);
    public Lista() {
        this.lista = new ArrayList<Integer>();
    }
    public Lista(ArrayList<Integer> list) { lista =list; }
    void dodaj_przod(int a)
    {
        lista.add(0, a);
    }
    void dodaj_tyl(int a) { lista.add( a); }
    void usun_tyl()
    {
        lista.remove(lista.size()-1);
    }
    void usun_przod()
    {
        lista.remove(0);
    }
    void pierwszy_el()
    {
        System.out.println(lista.get(0));
    }
    void ostatni_el()
    {
        System.out.println(lista.size()-1);
    }
    boolean pusta_lista()
    {
        return lista.isEmpty();
    }





}
