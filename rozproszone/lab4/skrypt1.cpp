#include<iostream>
#include<omp.h>
int main()
{
    const int size=8;
    int res[size];
    
    #pragma opm paraller num_threads(8)
    {
        std::cout<<omp_get_thread_num();
        
    }   
    
}