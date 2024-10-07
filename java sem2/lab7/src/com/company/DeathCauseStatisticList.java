package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class DeathCauseStatisticList {
    public Map <String,DeathCauseStatistic> map=new HashMap<>();
    public void repopulate(String path) throws FileNotFoundException {
        map.clear();
        try {
            Scanner scanner = new Scanner(new File(path));
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                DeathCauseStatistic statistic = DeathCauseStatistic.fromCsvLine(line);
                map.put(statistic.getICD_10(), statistic);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public Set<String> keys() {
        return map.keySet();
    }
    public List<DeathCauseStatistic> mostDeadlyDiseases (int age,int n)
    {
        List<DeathCauseStatistic> list=new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt((DeathCauseStatistic death)->death.age(age).deathCount).reversed());
        return list.subList(0,n);
    }


}
