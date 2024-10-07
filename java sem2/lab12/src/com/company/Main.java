package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static<E> List<E> addToList(List<E> list,E e, int index)//zad5
    {
        List<E> res= new ArrayList<>(list);
        res.add(index,e);
        return res;
    }
    public static<E> E[] addToarr(E[] list,E e, int index)//zad5
    {
        E[] res= Arrays.copyOf(list,list.length+1);
        for(int j=index;j<list.length;j++)
        {
            res[j+1]=list[j];
        }
        res[index]=e;
        return res;
    }

    public static List filter(List list, Class filerclass) //zad1
    {
        List res = new ArrayList();
        for (Object tmp:list)
        {
            if(filerclass.equals(tmp.getClass()))
                res.add(tmp);
        }
        return  res;

    }

    public static List filter1(List list, Class filerclass )//zad1
    {
        return list.stream().filter(item->filerclass.isInstance(item)).toList();
    }
    public static <T extends Comparable>int countRange(T[] arr, T start, T end) //zad3
    {
        RangePredicate<T> rangePredicate= new RangePredicate<T>(start, end);
       return(int) Arrays.stream(arr).filter(rangePredicate).count();
    }

        public static void main(String[] args) {
        List<Object> list = new ArrayList<>(List.of(10,13.2,"X",true,2)); //zad1
       // System.out.println(filter(list,Integer.class));
           // System.out.println(filter1(list,Number.class)); //zad1
            SortedList<Integer> sortedList= new SortedList<>(); //zad2
            sortedList.add(5);
            sortedList.add(15);
            sortedList.add(55);
            sortedList.add(4);
            sortedList.add(17);
            sortedList.add(14);
            for(int i=0;i<sortedList.size();i++)
                System.out.println(sortedList.get(i)); // zad2
            System.out.println("-----------------");
            Integer []arr= new Integer[] {1 ,3,5,8,10}; //zad3
            System.out.println(countRange(arr,4,9));//zad3
            System.out.println("-----------------");
            CountComparator comparator = new CountComparator<>(); //zad4
            System.out.println(comparator.compare(list,sortedList));
            List<Integer> list2 = new ArrayList<>(List.of(3,4,6,7));
            List<Integer> list1 = new ArrayList<>(List.of(1,2,3,4,5));
            SumComparator<List<Integer>,Integer> comparator1= new SumComparator<>();
            System.out.println(comparator1.compare(list1,list2)); //zad4
            System.out.println("-----------------");
            System.out.println(addToList(list1,15,3));
            Integer []arr1 = new  Integer[] {1,2,3,4};
            System.out.println(addToarr(arr1,15,2));
    }
}
