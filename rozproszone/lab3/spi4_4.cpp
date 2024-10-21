#include<iostream>
#include<omp.h>
int main()
{
    int size=100000;
    float *tab=new float[100000];
    float srednia=0;
    for (int i=0;i<size;i++)
        tab[i]=i;
    #pragma opm paraller for reduction(+: srednia)
        for (int i=0;i<size;i++)
            srednia+=tab[i];
    std::cout<<"srednia: "<<srednia/size<<std::endl;
}