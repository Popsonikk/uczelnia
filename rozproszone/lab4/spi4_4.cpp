#include<iostream>
#include<omp.h>
int main()
{
    int size=100000;
    long *tab=new long[size];
    
    for (int i=0;i<size;i++)
        tab[i]=i;
    const int threads_num=8;
    int op_count=threads_num;
    long long res[threads_num]={0};
    #pragma omp parallel num_threads(threads_num)
    {
        int index=omp_get_thread_num();
        #pragma omp for
        for (int i=0;i<size;i++)
            res[index]+=tab[i];
        for(int i =(threads_num/2);i>0;i/=2) 
        {
            #pragma omp for ordered
            for(int j =0;j<i;j++) 
            {
                res[j]+=res[j+i];
                #pragma omp ordered
                std::cout<<j<<": "<<res[j]<<std::endl;
            }
            #pragma omp barrier
        }
    }   
    std::cout<<"srednia: "<<(float)res[0]/size;
}