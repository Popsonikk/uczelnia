package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ICDCodeTabularOptimizedForTime implements ICDCodeTabular{
    Map<String,String> map=new HashMap<>();

    public ICDCodeTabularOptimizedForTime(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            for(int i=0;i<88;i++)
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if(line.matches("[A-Z][0-9][0-9].*"))
                {
                    String [] tab =line.split(" ",2); // podział lini na czesci po ' '
                    map.put(tab[0].trim(),tab[1]);
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDescription(String ICD_10) throws IndexOutOfBoundsException {
        if(map.containsKey(ICD_10)) // szukanie klucza
        {
            return map.get(ICD_10); //zwracanie wartosci pod kluczem
        }
        else
        {
            throw  new IndexOutOfBoundsException();
        }

    }
}
