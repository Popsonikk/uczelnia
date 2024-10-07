package com.company;

public class Math extends  Subject
{
    public Math(String name, float[] arr) {
        super(name, arr);
    }

    float avg()
    {
        float s = 0;
        int i = 0;
        for (float f : arr) {
            i++;
            s += f;
        }
        return s / i;
    }

    }
