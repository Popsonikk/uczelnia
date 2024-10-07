package com.company.person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TempPerson extends Person{
   private String path;
   List<String> parentName= new ArrayList<>();

    public String getPath() {
        return path;
    }

    public TempPerson(String name, LocalDate birth, LocalDate death, String path,List<String> list) {
        super(name, birth, death);
        this.path = path;
        this.parentName=list;
    }
    public  void convert(Map<String, TempPerson> tempPersonMap){
        for(String parname: parentName){
            Person person1 = tempPersonMap.get(parname);
            parents.add(person1);
        }
    }

}
