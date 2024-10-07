package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ClassTest {
    @Test
    void test()
    {
        String s=new String("C:\\Users\\popso\\OneDrive\\Pulpit\\kolokwium ustne\\src\\com\\company\\Man.jva");
        Class c=new  Class((s));
        Assertions.assertThrows(FileNotFoundException.class,c::path);
    }

}