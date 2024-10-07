package com.company;

import java.util.Collection;

import java.util.Comparator;

public class SumComparator<E extends Collection<T>,T extends Number> implements Comparator<E>
{

    @Override
    public int compare(E o1, E o2) {
        return Double.compare(
        o1.stream().map( T::doubleValue).reduce(0.0,Double::sum),
        o2.stream().map( T::doubleValue).reduce(0.0,Double::sum));
    }
}