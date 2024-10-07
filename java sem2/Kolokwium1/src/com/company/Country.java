package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public abstract class Country {
    private static class  CountryColumns{
        public final int firstColumnIndex;
        public final int columnCount;

        public CountryColumns(int firstColumnIndex, int columnCount) {
            this.firstColumnIndex = firstColumnIndex;
            this.columnCount = columnCount;
        }
    }
    private  final String name;
    private static String path;
    private  static String deathPath;

    public static void setPath(String path) {
        Country.path = path;
    }

    public static void setDeathPath(String deathPath) {
        Country.deathPath = deathPath;
    }

    public static void setFiles(String path, String deathPath) throws FileNotFoundException {
        File file1=new File(path);
        File file=new File(deathPath);
        if (file.exists()&&file1.exists())
        {
            setPath(path);
            setDeathPath(deathPath);
        }
        else
        {
            throw new FileNotFoundException(path+deathPath);

        }
    }

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public  static  Country fromCsv (String line)
    {

        Scanner scanner=new Scanner(path);
        String date;
        StringTokenizer stringTokenizer=new StringTokenizer(scanner.nextLine(),";");
        while (stringTokenizer.hasMoreTokens())
        {
            date=stringTokenizer.nextToken();

            if(line.equals(stringTokenizer.nextToken()))
            {

                if(stringTokenizer.nextToken()!=line)
                {

                    return new CountryWithoutProvinces(line);
                }
                else
                {
                   Country[] countries = new Country[0];
                   int a=0;
                    while (stringTokenizer.nextToken().equals(line))
                    {
                        countries[a] =new CountryWithoutProvinces(line);
                        a++;
                    }
                    return  new CountryWithProvinces(line,countries);

                }

            }
        }
        return null;
    }
    private static  CountryColumns getCountryColumns(String line, String country) throws  CountryNotFoundException
    {
        StringTokenizer tokenizer=new StringTokenizer(line,";");


        int index=0,count=1,i=0;

        while (tokenizer.hasMoreTokens())
        {
            ++i;
            if (tokenizer.nextToken().equals(country)) {
                index=i;
            }
            while (tokenizer.nextToken().equals(country))
            {
                count++;
            }

        }
        if(index==0)
        {
            throw  new CountryNotFoundException(line);
        }
        return  new CountryColumns(index,count);
    }
    public int getConfirmedCases (String date, String path){
        Scanner scanner=new Scanner(path);
        StringTokenizer tokenizer;
        int i=0;
        while(true) {
            tokenizer = new StringTokenizer(scanner.nextLine(), ";");
            if (tokenizer.nextToken().equals(date)) {
                break;
            }

        }
        while(tokenizer.hasMoreTokens())
            i+=Integer.parseInt(tokenizer.nextToken());
        return i;
    }
    public int getDeaths (String date, String deathPath){
        Scanner scanner=new Scanner(deathPath);
        StringTokenizer tokenizer;
        int i=0;
        while(true) {
            tokenizer = new StringTokenizer(scanner.nextLine(), ";");
            if (tokenizer.nextToken().equals(date)) {
                break;
            }

        }
        while(tokenizer.hasMoreTokens())
            i+=Integer.parseInt(tokenizer.nextToken());
        return i;
    }
    public void saveTodataFile(String path1,String path,String deathPath)  {
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter(path1));
            Scanner scan=new Scanner(path);
            scan.nextLine();
            scan.nextLine();
            StringTokenizer tokenizer;
            String date;
            while (scan.hasNextLine())
            {
                tokenizer=new StringTokenizer(scan.nextLine(),";");
                date=tokenizer.nextToken();
                writer.write(date);
                writer.write(";");
                writer.write(getConfirmedCases(date,path));
                writer.write(";");
                writer.write(getDeaths(date,deathPath));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public  static  Country fromCsv (String[] line) {
        for (String lin : line) {
            Scanner scanner = new Scanner(path);
            StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine(), ";");
            while (stringTokenizer.hasMoreTokens()) {

                if (line.equals(stringTokenizer.nextToken())) {

                    if (stringTokenizer.nextToken() != lin) {
                        return new CountryWithoutProvinces(lin);
                    } else {
                        Country[] countries = new Country[0];
                        int a = 0;
                        while (stringTokenizer.nextToken().equals(lin)) {
                            countries[a] = new CountryWithoutProvinces(lin);
                            a++;
                        }
                        return new CountryWithProvinces(lin, countries);

                    }

                }
            }

        }
        return null;
    }
    //public  static   Country [] sortByDeath(Country [] countries,String date1,String date2)
   // {
  //      return Arrays.sort(Comparator.comparingInt(Country countries)->countries.getDeaths(date1,deathPath));
  //  }

}
