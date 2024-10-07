package com.company;

import java.util.Arrays;
import java.util.StringTokenizer;

public class DeathCauseStatistic {
    private String ICD_10;
    private int [] deaths;
    public class  AgeBracketDeaths{
        public final int young, old, deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }


    }
    public DeathCauseStatistic(String ICD_10, int[] deaths) {
        this.ICD_10 = ICD_10;
        this.deaths = deaths;
    }
    public String getICD_10() {
        return ICD_10;
    }
    @Override
    public String toString() {
        return "DeathCauseStatistic{" +
                "ICD_10='" + ICD_10 + '\'' +
                ", deaths=" + Arrays.toString(deaths) +
                '}';
    }
    public  static DeathCauseStatistic fromCsvLine (String line) {
        String ICD_10=null;
        int[] deaths =new int[20];
        StringTokenizer tokenizer=new StringTokenizer(line,",");
        ICD_10=tokenizer.nextToken();
        tokenizer.nextToken();//pominiecie zbiorczej liczby smierci
        ICD_10=ICD_10.trim(); // usuniecie spacji z tabulatora
        for(int i=0;i<20;i++)
        {
            String s=tokenizer.nextToken();
            if(s.equals("-"))
            {
                deaths[i]=0;
            }
            else {
                deaths[i]=Integer.parseInt(s);
            }
        }
         return  new DeathCauseStatistic(ICD_10,deaths);
    }
    public AgeBracketDeaths age (int year)
    {
        int y;
        if(year<95)
            y=year/5;
        else
            y=19;
        return new AgeBracketDeaths(y*5,y*5+4,deaths[y]);
    }
}
