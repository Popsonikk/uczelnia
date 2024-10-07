package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CountryWithoutProvinces extends Country {

    public CountryWithoutProvinces(String name) {
        super(name);

    }



    @Override
    public String getName() {
        return super.getName();
    }


    private static class DailyStatistic {
        public LocalDate date;
        public final int deaths;
        public final int ills;

        public DailyStatistic(LocalDate date, int deaths, int ills) {
            this.date = date;
            this.deaths = deaths;
            this.ills = ills;
        }
    }
    private int getIndex(String path,String line)
    {
        int i=0;
        Scanner scanner=new Scanner(path);
        StringTokenizer tokenizer=new StringTokenizer(scanner.nextLine(),";");
        while (tokenizer.nextToken()!=line)
        {
            i++;
        }
        return i;

    }
    private int getCount(String path,LocalDate date,String line)
    {
        int i=getIndex(path,line);
        Scanner scan=new Scanner(path);
        StringTokenizer tokenizer;
        while(true)
        {
            tokenizer=new StringTokenizer(scan.nextLine(),";");
            if(tokenizer.nextToken().equals(date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))))
            {
                break;
            }

        }
        for(int j=0;j<i;i++)
        {
            tokenizer.nextToken();
        }
       return  Integer.parseInt(tokenizer.nextToken());
    }
    private DailyStatistic addDailyStatistc(LocalDate date,String path,String deathPath,String line)
    {
        return new DailyStatistic(date,getCount(path,date,line),getCount(deathPath,date,line));

    }
}