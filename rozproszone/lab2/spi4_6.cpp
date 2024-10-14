#include<iostream>
#include<omp.h>
#include <cstdlib>
#include <time.h> 
bool f1(int a)
{
    return a%2==0;
}
bool f2(int a)
{
    return a%3==0;
}
bool f3(int a)
{
    return a<80;
}
bool f4(int a)
{
    return a>20;
}
bool f5()
{
    return true;
}
int main()
{
    bool a1,a2,a3,a4,a5;
     srand (time(NULL));
    int r= rand() % 100 + 1; 
    std::cout<<"Wylosowano: "<<r<<std::endl;
    #pragma omp parallel num_threads(4)
    {
        #pragma omp sections
        {
            
            #pragma omp section
            {
                a1=f1(r);
            }
            #pragma omp section
            {
               a2=f2(r); 
            }
            #pragma omp section
            {
                a3=f3(r);
            }
            #pragma omp section
            {
                a4=f4(r);
            }
            #pragma omp section
            {
                a5=f5();
            }
        }
    }
    std::cout<<a1<<" "<<a2<<" "<<a3<<" "<<a4<<" "<<a5<<std::endl;
    bool res=a1&&a2&&a3&&a4&&a5;
    std::cout<<res;
}