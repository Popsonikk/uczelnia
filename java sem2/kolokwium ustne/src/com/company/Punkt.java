package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Punkt {
    public  final float x;
    public  final float y;

    public Punkt(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] arrays (Punkt[]tab)
    {
        float[] result= new  float[tab.length];
        for(int i=0;i< tab.length;i++)
        {
            result[i]= (float) Math.sqrt(x*x+y*y);
        }
        Arrays.sort(result);
        return  result;
    }

}
