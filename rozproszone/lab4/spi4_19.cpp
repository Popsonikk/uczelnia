#include<iostream>
#include<omp.h>
#include <cmath>
double f(double x) {
    return x + std::sin(1 / x);  
}
int main()
{
    int ilosc=10000;
    double a=0.01;
    double b=1.0;
    double h = (b - a) / ilosc;  // Szerokość przedziału
    double boki = 0.5 * (f(b) + f(a));
    const int threads_num=8;
    double p[threads_num]={0};
    #pragma omp parallel num_threads(threads_num)
    {
        int index=omp_get_thread_num();
                 #pragma omp for
        for(int i=1;i<ilosc;i++)
            p[index]+=f(a+h*i);
        for(int i =(threads_num/2);i>0;i/=2) 
        {
            #pragma omp for ordered
            for(int j =0;j<i;j++) 
                p[j]+=p[j+i];
            #pragma omp barrier
        }
    }
    std::cout<<"pole: "<<(p[0]+boki)*h;

}