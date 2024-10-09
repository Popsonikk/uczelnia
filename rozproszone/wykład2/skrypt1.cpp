#include<iostream>
#include<omp.h>
int main()
{
    int iam;
    #pragma omp parallel private (iam)
    {
        iam=omp_get_thread_num();
        int i;
        #pragma omp for schedule(dynamic,4) ordered
        for(i=0;i<32;i++)
        {
            #pragma omp ordered
            std::cout<<"Watek "<<iam<<" wykonuje "<<i<<std::endl;
        }

    }

}