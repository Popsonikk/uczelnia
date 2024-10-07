package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class MainTest {
    @Test
    void sum() {
        int a=-10,b=10;
        int result=Main.sum(a,b);
        Assertions.assertEquals(0,result);
    }
}