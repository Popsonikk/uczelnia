#include<iostream>
#include<omp.h>
long int fib(int n)
{
    if(n<=2)
        return 1;
    else
    {
        long int i1,i2;
        #pragma omp task shared(i1) if(n>=35)
        {
            i1=fib(n-1);
        }
        #pragma omp task shared(i2) if(n>=35)
        {
            i2=fib(n-2); 
        }
        #pragma omp taskwait
        return i1+i2;
    }
        
}
int main()
{
   /* #pragma omp parallel
    {
        #pragma omp sections
        {
            #pragma omp section
            {
                int licznik1=0;
                for(int i=0;i<500000000;i++)
                    licznik1++;
                std::cout<<licznik1<<std::endl;
            }
            #pragma omp section
            {
                int licznik2=0;
                for(int i=0;i<500000000;i++)
                    licznik2++;
                std::cout<<licznik2<<std::endl;              
            }
        }
    }*/
  /* #pragma omp parallel // wymuszenie uruchomienia wątków
   {
        #pragma omp single // jeden watek tworzący taski
        {
            #pragma omp task //watek tworzy zadanie a nie programista
            {
                int licznik1=0;
                for(int i=0;i<500000000;i++)
                    licznik1++;
                std::cout<<licznik1<<std::endl;
            }
            #pragma omp task
            {
                int licznik2=0;
                for(int i=0;i<500000000;i++)
                    licznik2++;
                std::cout<<licznik2<<std::endl;  
            }
        }
        
   }*/
    #pragma omp parallel
    {
        #pragma omp single
        {
            std::cout<<fib(40);
        }
    }
}