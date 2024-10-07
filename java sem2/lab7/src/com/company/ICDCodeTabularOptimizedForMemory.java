package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ICDCodeTabularOptimizedForMemory implements  ICDCodeTabular{
    private String path;

    public ICDCodeTabularOptimizedForMemory(String path) {
        this.path = path;
    }

    @Override
    public String getDescription(String ICD_10) throws IndexOutOfBoundsException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
            for(int i=0;i<87;i++)
                scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line=scanner.nextLine();
                if(line.matches("[A-Z][0-9][0-9].*")) // szukanie wzorca
                {
                    String [] tab =line.split(" ",2);
                    if(tab[0].equals(ICD_10))
                    {
                        return tab[1];
                    }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        throw new IndexOutOfBoundsException();


    }
}
