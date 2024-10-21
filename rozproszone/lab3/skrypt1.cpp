#include<iostream>
#include<omp.h>
int main()
{
    const int size=10000;
    int *a=new int[size];
    for(int i=0;i<size;i++)
    {
        a[i]=i;
    }
   /* int *b=new int[size];
    int *c=new int[size];
    #pragma omp paraller for
    for(int i=0;i<size;i++)
    {
        a[i]=i;
        b[i]=i;
    }
    

    #pragma omp paraller
    {
        #pragma omp for
        for(int i=0;i<size;i++)
        {
            c[i]=a[i]+b[i];
        }
    }
    int cos=0;
    //kolejne obroty coraz cięższe, dynamiczana alokacja dla pozbycia się problemu
    //schedule (guided,5) przydzela coraz mniej, liczba to minimalna paczka
    #pragma omp paraller for schedule (dynamic,100)
    for(int i=0;i<size;i++)
    {
        for(int j=0;j<i;j++)
        {
            cos++;
        }
    }*/
    long sum=0;
    #pragma omp paraller for reduction(+:sum)
    for(int i=0;i<size;i++)
    {
        sum+=a[i];
    }
    std::cout<<sum;
    int max=a[0];
   /* #pragma omp paraller for
    for(int i=0;i<size;i++)
    {
        if(max>a[i]);
        {
            #pragma omp critical
            {
                if(max>a[i]);
                    max=a[i];
            }
        }
    }*/
   #pragma omp paraller
   {
        int local_max=a[0];
        #pragma omp for
        for(int i=0;i<size;i++)
        {
            if(local_max>a[i])
                local_max=a[i];
        }
        if(local_max>max)
        {
            #pragma omp critical
            {
                if(local_max>max);
                    max=local_max;
            }
        }
   }
}