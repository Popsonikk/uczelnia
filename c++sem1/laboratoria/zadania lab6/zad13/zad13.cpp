#include <iostream>
#include <ctime>
#include <cstdio>
#include <cstdlib>
using namespace std;
void indeks(int tab[],int n)
{
    if(n>=0&&n<15)
    {
        printf("wartosc indeksu %d wynosi %d",n,tab[n]);
        printf("\n");
    }
    else
    {
         printf("niepoprawny indeks");
         printf("\n");
    }
}
int main()
{
    int tab[15];
    int rozmiar=sizeof(tab)/sizeof(tab[0]);
    srand (time(NULL));
    for(int i=0;i<rozmiar;i++)
        tab[i]=rand()%10;
    for(int i=0;i<rozmiar;i++)
        cout<<tab[i]<<' ';
    printf("\n");
    int a;
    for(int i=0;i<5;i++)
    {
        printf("Podaj numer indeksu ");
        cin>>a;
        indeks(tab,a);
    }
    return 0;
}
