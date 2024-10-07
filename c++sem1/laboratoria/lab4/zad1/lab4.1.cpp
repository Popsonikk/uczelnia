#include<iostream>
#include<cstdlib> //od funkcji rand
#include <limits>
int main()
{
    int n;
    std::cout<<"podaj n ";
    std::cin>>n;
    double tab[n];
    for(int i=0;i<n;i++)
        tab[i]=rand()%15;
    double suma=0;
    for(int i=0;i<n;i++)
        suma+=tab[i];
    suma/=5;
    for(int i=0;i<n;i++)
        tab[i]=rand()%5;
    double roznica=0, minroznica=std::numeric_limits<double>::max();
    int indeks=0;
    for(int i=0;i<n;i++)
    {
        roznica = abs(tab[i]-suma); //wartosc bezwzgledna
        if(minroznica>=roznica)
           {
               minroznica=roznica;
               indeks=i;
           }
    }
std::cout<<"index "<<indeks<<" wartosc "<<tab[indeks];
return 0;
}
