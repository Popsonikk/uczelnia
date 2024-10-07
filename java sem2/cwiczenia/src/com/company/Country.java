package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public abstract class Country {
    private final String name;
    private static String path;
    private static String deathPath;

    public Country(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDeathPath(String deathPath) {
        this.deathPath = deathPath;
    }

    public String getName() {
        return name;
    }
    public void setFiles(String path,String deathPath) throws FileNotFoundException {
        File file1= new File(path);
        File file2= new File(deathPath);
        if(file1.exists())
            setPath(path);
        else
            throw new FileNotFoundException(path);
        if(file2.exists())
            setDeathPath(deathPath);
        else
            throw new FileNotFoundException(deathPath);
    }
    public static Country fromCSV (String name)
    {
        int i=1;
        try {
            BufferedReader reader= new BufferedReader(new FileReader(path));
            StringTokenizer countrytokenizer=new StringTokenizer(reader.readLine());
            StringTokenizer provincestokenizer=new StringTokenizer(reader.readLine());
            while (countrytokenizer.hasMoreTokens())
            {
                provincestokenizer.nextToken();
                if(countrytokenizer.nextToken().equals(name))
                {
                    Country[ ]countries= new Country[0];
                    countries[0]= new CountryWithoutProvinces(name);
                    while(countrytokenizer.nextToken().equals(name))
                    {
                        countries[i++]=new CountryWithoutProvinces(provincestokenizer.nextToken());
                    }
                    if(countries.length==1)
                        return new CountryWithoutProvinces(name);
                    else
                        return  new CountryWithProvinces(name,countries);
                }

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
