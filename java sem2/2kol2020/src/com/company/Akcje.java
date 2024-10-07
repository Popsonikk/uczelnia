package com.company;

import java.util.Random;

public class Akcje extends  Papieryw{
    public Akcje(float wartosc, int id) {
        super(wartosc, id);
    }

    @Override
    public void step() {
        Random r=new Random();
       if( r.nextBoolean())
           setWartosc(getWartosc()*(float)1.1);
       else
           setWartosc(getWartosc() * (float) 0.9);
    }
}
