package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class StringlistTest {

    Stringlist stringlist;
    @BeforeEach
    void init()
    {
        stringlist=new Stringlist();
    }
    @Test
    void singleValuePrepend() {
        stringlist.prepend("ala");
        Assertions.assertEquals("ala",stringlist.first());
    }
    @Test
    void multiValuePrepend() {
        stringlist.prepend("ala");
        stringlist.prepend("ola");
        stringlist.prepend("kot");
        Assertions.assertEquals("kot",stringlist.first());
    }
    @Test
    void removeFirst()
    {
        stringlist.prepend("ala");
        stringlist.prepend("ola");
        stringlist.removeFirst();
        Assertions.assertEquals("ala",stringlist.first());
    }
    @Test
    void noValueFirst()
    {
        Assertions.assertThrows(IndexOutOfBoundsException.class,stringlist::first);
    }
    @Test
    void noValueRemoveFirst()
    {
        Assertions.assertThrows(IndexOutOfBoundsException.class,stringlist::removeFirst);
    }
    @Test
    void multiValueAppend() {
        stringlist.prepend("ala");
        stringlist.prepend("ola");
        stringlist.prepend("kot");
        Assertions.assertEquals("ala",stringlist.last());
    }
    @Test
    void noValueLast()
    {
        Assertions.assertThrows(IndexOutOfBoundsException.class,stringlist::last);
    }
    @Test
    void Append() {
        stringlist.append("ala");
        stringlist.append("ola");
        stringlist.append("kot");
        Assertions.assertEquals("kot",stringlist.last());
    }
    @Test
    void removeLast()
    {
        stringlist.append("ala");
        stringlist.append("ola");
        stringlist.append("kot");
        stringlist.removeLast();
        Assertions.assertEquals("ola",stringlist.last());
    }
    @Test
    void geti() {
        stringlist.prepend("ala");
        stringlist.prepend("ola");
        stringlist.prepend("kot");
        stringlist.prepend("ania");
        Assertions.assertEquals("ola",stringlist.get(2));
    }
    @Test
    void insert() {
        stringlist.prepend("ala");
        stringlist.prepend("ola");
        stringlist.prepend("kot");
        stringlist.prepend("ania");
        stringlist.insert("piesek",2);
        Assertions.assertEquals("ola",stringlist.get(3));
    }
    @Test
    void remove() {
        stringlist.prepend("ala");
        stringlist.prepend("ola");
        stringlist.prepend("kot");
        stringlist.prepend("ania");
        stringlist.remove(1);
        Assertions.assertEquals("ola",stringlist.get(2));
    }
}