#include<iostream>
#include<omp.h>
int main()
{
    //przed zmienna shared
    int licznik =0;
     /* #pragma omp parallel num_threads(4)
    {
        //wewnątrz zmienna private
        for(int i=0;i<1000;++i)
        {
           //wąskie gardło, tylko jeden wątek na raz
            #pragma omp critical
            {
                licznik++;
            }
           //blok atomowy pojedynczy dostęp
            #pragma omp atomic
            {
                licznik++;
            }
        }
            
    }*/
   //prywatna licznyk sumowany na koniec, wątki 
   #pragma omp parallel num_threads(4)
   {
        int prywatny=licznik;
        //czekamy aż wszystkie wątky dojdą do tego samego miejsca
        #pragma omp barrier
        for(int i=0;i<1000;++i)
        {
           prywatny++;
        }
        
        #pragma omp atomic
            licznik+=prywatny;
   }
    std::cout<<licznik<<std::endl;
    
}