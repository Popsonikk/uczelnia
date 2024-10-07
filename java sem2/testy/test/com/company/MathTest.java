package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {


    @Test
    void avg()
    {
        float[] arr={4,5,2,1,3};
        Subject s= new  Math("math",arr);
        Assertions.assertEquals(3,s.avg());
    }

}