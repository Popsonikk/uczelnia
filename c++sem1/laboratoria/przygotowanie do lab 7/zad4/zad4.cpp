#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
using namespace std;
int* zmien(int* tab,int n,int x)
{
    int i=0;
    int* wsk= nullptr;
    while(wsk==nullptr&&i<n)
    {
        if(*(tab+i)==x)
        {
            wsk=(tab+i);
            return wsk;
        }
        i++;
    }
    if(wsk==nullptr)
        return wsk;
}
int main()
{
    int tab[10];
    srand(time(NULL));
    int x;
    cout<<"podaj szukana wartosc ";
    cin>>x;
    for(int i=0;i<10;i++)
        tab[i]=rand()%5;
    int rozmiar=sizeof(tab)/sizeof(tab[0]);
    for(int i=0;i<10;i++)
        cout<<tab[i]<<' ';
    printf("\n");
    cout<<"adres szukanej zmiennej "<<zmien(tab,rozmiar,x);

}
