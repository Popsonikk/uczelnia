#include<iostream>
#include<omp.h>
#include <cstdlib>
#include <time.h> 

int main()
{
    srand (time(NULL));
    int points=0;
    #pragma omp parallel num_threads(4) reduction(+: points) 
    {
       for(int i=0;i<1000000;i++)
       {
            int x= rand() % 101; 
            int y= rand() % 101; 
            if(x*x+y*y<=10000)
            points++;
       }   
    }
    std::cout<<"Pi wynosi: "<<(double)4*points/4000000;
    
}