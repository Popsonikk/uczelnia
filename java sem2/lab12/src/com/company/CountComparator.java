package com.company;

import java.util.Collection;

import java.util.Comparator;

public class CountComparator<E extends Collection<?>> implements Comparator<E>
{

    @Override
    public int compare(E o1, E o2) {
        return o1.size()-o2.size();
    }
}
