package com.company;

public class Delta {
    private double a;
    private double b;
    private double c;
    private double x1;
    private double x2;
    double delta;

    public void czytajDane(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }
    public  void przetworDane()
    {
        if(a!=0)
        {
            delta= b*b-4*a*c;
            if(delta==0)
            {
                x1=b/(2*a);
            }
            else if (delta>0)
            {
                x1=(-b-Math.sqrt(delta))/2*a;
                x2=(-b+Math.sqrt(delta))/2*a;
            }
        }
        else if(b != 0)
        {
            x1=c/b;
        }



    }
    void wyswietlWynik()
    {
        if(delta<0)
            System.out.println("brak miejsc");
        else if(delta==0||(a==0&&b!=0))
            System.out.println("x1 wynosi "+x1);
        else
            System.out.println("x1 wynosi "+x1+" x2 wynosi "+x2);
    }
}
