package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public    class Pliktekstowy {
    private  String s;
    private int i;

   public Pliktekstowy(String s, int i) {
       this.s = s;
       this.i = i;
    }
    public static  String metoda(String s,int i)
    {
        try {
            BufferedReader reader=new BufferedReader(new FileReader(s));
            for(int j=0;j<i-1;j++)
            {
                reader.readLine();
            }
             return  reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
