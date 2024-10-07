package com.company.person;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectoryPersonPersistenceManager implements PersonPersistenceManager {
    private enum FileExeptation {expectdeath, exepctparrents, expectchild}

    public void toFile(String path, Person person) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(person.name+"\n");
            writer.write(Person.parseDate(person.birth)+"\n");
            if(person.death != null) {
                writer.write(Person.parseDate(person.death)+"\n");
            }
            writer.close();
        } catch (IOException | NullPointerException | DateTimeParseException e) {
            //e.printStackTrace();
        }
    }
    public TempPerson fromFile(String path) {
        String name = null;
        LocalDate birth = null, death = null;
        List<String> parentname = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            name = reader.readLine();
            birth = Person.parseDate(reader.readLine());
            FileExeptation num1= FileExeptation.expectdeath;
            String line;
            while(null != (line = reader.readLine())){
                switch (num1){
                    case expectdeath:if(line.equals("Rodzice:"))
                    {
                        num1 = FileExeptation.exepctparrents;
                    }
                    else {
                        death = Person.parseDate(line);
                    }
                        break;
                    case exepctparrents:
                        parentname.add(line);
                        break;
                }
            }


            //death = Person.parseDate(reader.readLine());
            reader.close();

        } catch (IOException | NullPointerException | DateTimeParseException e) {
            //e.printStackTrace();
        }
        return new TempPerson(name, birth, death, path, parentname);
    }
    @Override
    public Person[] load(String path) {

        File[] files = new File(path).listFiles();
        //Person[] result = new Person[files.length];
        Map <String, TempPerson>tempPersonMap = new HashMap<>();
        for(int i=0; i<files.length; i++) {
            //result[i] = fromFile(files[i].getPath());
            TempPerson person = fromFile(files[i].getPath());
            if(tempPersonMap.containsKey(person.name)){
                throw new AmbigiousPersonException(person.getPath(), tempPersonMap.get(person.name).getPath());
            }else{
                tempPersonMap.put(person.name, person);
            }
        }
        for(Map.Entry<String, TempPerson>pair:tempPersonMap.entrySet()){
            pair.getValue().convert(tempPersonMap);


        }
        return tempPersonMap.values().toArray(new TempPerson[0]);
    }

    @Override
    public void save(String path, Person[] people) {
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (var file : files)
                file.delete();
        } else {
            try {
                Files.createDirectory(dir.toPath());
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }

        for (Person person : people) {
            toFile(path + "/" + person.name + ".txt", person);
        }

    }
}