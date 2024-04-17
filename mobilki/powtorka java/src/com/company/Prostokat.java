package com.company;

import java.util.Scanner;

public class Prostokat {
    Scanner scanner= new Scanner(System.in);
    private double a;
    private double b;
    void czytajDane()
    {
        System.out.println("Podaj 1 bok ");
        this.a=scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Podaj 2 bok ");
        this.b=scanner.nextDouble();
        scanner.nextLine();
    }
    double przetworzDane()
    {
        return Math.round(a*b * 100.0) / 100.0 ;
    }
    double wyswietlWynik()
    {
        return przetworzDane();
    }
}
