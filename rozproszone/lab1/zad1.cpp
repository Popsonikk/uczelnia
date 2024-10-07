//openmp
//-fopenmp
#include <iostream>
#include <omp.h>

int main()
{
    int a[100];
    int b[100];
    int c[100];
    for(int i=0;i<100;i++)
    {
        a[i]=i;
        b[i]=i+1;
    }

    #pragma omp parallel num_threads(4) 
    {
        int x=omp_get_thread_num();
        int j=x%4;
        for(int i=0;i<25;i++)
        {      
            c[4*i+j]=a[j+4*i]+b[j+4*i];
        }
    
    }
    for(int i=0;i<100;i++)
    {
        std::cout<<"pozycja "<<i<<": "<<c[i]<<std::endl;
    }
   

   

}

