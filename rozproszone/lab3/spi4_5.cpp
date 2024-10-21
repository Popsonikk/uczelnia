#include<iostream>
#include<omp.h>
int main()
{
    int size=100000;
    float sum=0;
    #pragma opm paraller for reduction(+: sum)
        for (int i=1;i<size;i++)
            sum-=(1.f/i);
    std::cout<<"suma: "<<sum<<std::endl;
}