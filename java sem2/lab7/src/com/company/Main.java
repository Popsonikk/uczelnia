package com.company;

import java.io.FileNotFoundException;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        DeathCauseStatistic cause=DeathCauseStatistic.fromCsvLine("A02.1          ,5,-,-,-,-,-,-,-,-,-,-,-,-,1,2,-,1,1,-,-,-");
        System.out.println(cause.toString());
       DeathCauseStatistic.AgeBracketDeaths age= cause.age(62);
       System.out.println(age.deathCount);
       DeathCauseStatisticList list= new DeathCauseStatisticList();
       list.repopulate("C:\\Users\\popso\\OneDrive\\Pulpit\\progrmowanie\\java sem2\\lab7\\zgony.csv");
        Set<String> kody_chor = list.keys();
        System.out.println(kody_chor);
        ICDCodeTabularOptimizedForMemory code = new ICDCodeTabularOptimizedForMemory("C:\\Users\\popso\\OneDrive\\Pulpit\\progrmowanie\\java sem2\\lab7\\icd10.txt");
        System.out.println(code.getDescription("A04"));
    }

}
