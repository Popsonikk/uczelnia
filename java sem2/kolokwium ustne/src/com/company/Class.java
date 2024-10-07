package com.company;

import java.io.File;
import java.io.FileNotFoundException;

public class Class {
    private String s;

    public Class(String s) {
        this.s = s;
    }

    void path() throws FileNotFoundException
    {

        File file = new File(s);
        if(!file.isDirectory())
            throw  new FileNotFoundException();

    }
}
