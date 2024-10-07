package com.company;

import java.util.function.Predicate;

public class RangePredicate<T extends  Comparable> implements Predicate<T> {

    private  T start;
    private  T end;
    RangePredicate(T start,T end)
    {
        this.start=start;
        this.end=end;
    }
    @Override
    public boolean test(T t) {
        return t.compareTo(start)>0 &&t.compareTo(end)<0;
    }
}
