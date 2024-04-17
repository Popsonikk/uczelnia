package com.company;
import java.util.Scanner;

public class Kalkulator {
    double wynik;
    Scanner scanner = new Scanner(System.in);

    public Kalkulator() {
        this.wynik = 0;
    }


    public double getWynik() {
        return wynik;
    }

    void  dodaj(Boolean flag)
    {
        if(flag)
        {
            System.out.println("Podaj 1 liczbe  ");
            double a=scanner.nextDouble();
            scanner.nextLine();
            wynik+=a;
        }
        else
        {
            System.out.println("Podaj 1 liczbe  ");
            double a=scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Podaj 2 liczbe  ");
            double b=scanner.nextDouble();
            scanner.nextLine();
            wynik=a+b;
        }
        System.out.println("wynik wynosi "+ getWynik());
    }
    void  odejmij(Boolean flag)
    {
        if(flag)
        {
            System.out.println("Podaj 1 liczbe  ");
            double a=scanner.nextDouble();
            scanner.nextLine();
            wynik-=a;
        }
        else
        {
            System.out.println("Podaj 1 liczbe  ");
            double a=scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Podaj 2 liczbe  ");
            double b=scanner.nextDouble();
            scanner.nextLine();
            wynik=a-b;

        }
        System.out.println("wynik wynosi "+ getWynik());
    }
    void  mnozenie(Boolean flag)
    {
        if(flag)
        {
            System.out.println("Podaj 1 liczbe  ");
            double a=scanner.nextDouble();
            scanner.nextLine();
            wynik*=a;
        }
        else
        {
            System.out.println("Podaj 1 liczbe  ");
            double a=scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Podaj 2 liczbe  ");
            double b=scanner.nextDouble();
            scanner.nextLine();
            wynik=a*b;
        }
        System.out.println("wynik wynosi "+ getWynik());
    }
    void podziel(Boolean flag)
    {
        if(flag)
        {
            System.out.println("Podaj 1 liczbe  ");
            double a=scanner.nextDouble();
            scanner.nextLine();
            wynik/=a;
        }
        else
        {
            System.out.println("Podaj 1 liczbe ");
            double a=scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Podaj 2 liczbe  ");
            double b=scanner.nextDouble();
            scanner.nextLine();
            wynik=a/b;
        }
        System.out.println("wynik wynosi "+ getWynik());
    }
    void zlozenie()
    {
        Boolean flag=false;
        while(true)
        {
            System.out.println("podaj dzialanie 1.dodwanie  2.odejmowanie" +
                    "3.mnożenie  4.dzielenie 5.koniec ");
            int c= scanner.nextInt();
            scanner.nextLine();
            if(c==1)
                dodaj(flag);
            else if(c==2)
                odejmij(flag);
            else if(c==3)
                mnozenie(flag);
            else if(c==4)
                podziel(flag);
            else if(c==5)
                return;
            flag=true;
        }
    }
    void resetWyniku()
    {
        this.wynik = 0;
    }
}
