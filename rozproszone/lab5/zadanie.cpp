#include<iostream>
#include<omp.h>
float f(int n,float a1,float r)
{
    if(n==1)
        return a1;
    else
    {
        float a;
        #pragma omp task shared(a,a1,r) 
        {
            a=f(n-1,a1,r);
        }
        #pragma omp taskwait
        return a+r;
    }
        
}
int main()
{
    #pragma omp parallel
    {
        #pragma omp single
        {
            std::cout<<f(4000,2.5,11.3);
        }
    }
    
    
}