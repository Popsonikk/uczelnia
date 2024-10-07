package com.company;

import java.util.*;

public class SortedList<E extends Comparable> implements List<E>  {

    private ArrayList<E> arrayList= new ArrayList<>();

    @Override
    public int size() {
        return arrayList.size();
    }
    @Override
    public boolean add(E e) {
        if(arrayList.size()==0)
            return arrayList.add( e);
        else
        {
            int right=arrayList.size()-1,left=0,middle=(right+left)/2;
            while(left<=right)
            {
                if(arrayList.get(middle).compareTo(e)>0) {
                    right = middle -1;

                }
                else
                {
                    left=middle+1;
                }
                middle=(right+left)/2;


            }
            arrayList.add(left, e);
        }
        return true;

    }
    @Override
    public void add(int index, E element) {

    }
    @Override
    public E get(int index) {
        return arrayList.get(index);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }



    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }



    @Override
    public E set(int index, E element) {
        return null;
    }



    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
