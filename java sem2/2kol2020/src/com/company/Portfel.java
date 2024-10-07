package com.company;

public class Portfel
{
    private Papieryw [] table;

    public Portfel(Papieryw[] table) {
        this.table = table;
    }
    public  void  step()
    {
        for(Papieryw p:table)
        {
            p.step();
        }
    }
    public  float  cost()
    {
        float sum=0;
        for(Papieryw p:table)
        {
            sum+=p.getWartosc();
        }
        return  sum;
    }
}
