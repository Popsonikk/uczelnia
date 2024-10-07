package com.company;

public class Main {

    public static void main(String[] args) {
        Figura trójkąt= new Trójkąt(4,4,6);
        Figura trapez= new Trapez(4,4,6);
        System.out.println(trójkąt.pole());
        System.out.println(trapez.pole());
    }
        Punkt a=new Punkt(0,1);
    Punkt b=new Punkt(0,3);
    Punkt c=new Punkt(0,2);
    Punkt d=new Punkt(0, 0.5F);
    Punkt e=new Punkt(0,1.4F);
    Punkt[]arr=new Punkt[]{a,b,c,d,e};

}
