#include<iostream>
#include<omp.h>
int main()
{
    int licznik=0;
    //int a,c,b;
    //#pragma omp parallel private(a)
    //#pragma omp parallel default(private) shared(a,b)
    
    //redukcja licznik traktowany jako prywatny, na końcu prywantne są zwijane do globalnej za pomocą działania w nawiasie +: 
   #pragma omp parallel reduction(+: licznik) 
   {
        licznik=omp_get_thread_num();
        std::cout<<"czesc"<<std::endl;
        //kod wykonany jednorazowo przez pierwszy wątek, który dojdzie
        #pragma omp single
        {
            std::cout<<"Pozdrawiam z watku "<<omp_get_thread_num()<<std::endl;
        }//niejawna bariera czekamy, aż wątek wykonujący single skończy, zdjęcie za pomocą nowait;
        //master wymusza przez wątek 0 bez bariery
        #pragma omp sections
        {
            //bloki singli mogące być wykonane jednoczeście
            #pragma omp section
            {
                std::cout<<"Pozdrawiam z sekcji A watku "<<omp_get_thread_num()<<std::endl;
            }
            #pragma omp section
            {
                std::cout<<"Pozdrawiam z sekcji B  watku "<<omp_get_thread_num()<<std::endl;
            }
            #pragma omp section
            {
                std::cout<<"Pozdrawiam z sekcji C watku "<<omp_get_thread_num()<<std::endl;
            }
        }
   }


   std::cout<<licznik<<std::endl;
    
    
}