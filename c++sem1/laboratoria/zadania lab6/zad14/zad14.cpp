#include <iostream>
#include <ctime>
#include <cstdio>
#include <cstdlib>
using namespace std;
int tablica(int tab[],int n,bool a)
{
    int i=0,j=1;
    while(i<n)
    {
        if(tab[i]==tab[j])
        {
            a=true;
            break;
        }
        if(j+1==n)
        {
            ++i;
            j=i+1;
        }
        j++;
    }
    if(a)
        return tab[i];
    else
        return 0;
}
int main()
{
    int tab[20];
    int rozmiar=sizeof(tab)/sizeof(tab[0]);
    srand (time(NULL));
    for(int i=0;i<rozmiar;i++)
        tab[i]=rand()%15;
    for(int i=0;i<rozmiar;i++)
        cout<<tab[i]<<' ';
    printf("\n");
    bool a=0;
    cout<<"powtarzajacy sie elemeny to "<<tablica(tab,rozmiar,a);
    return 0;
}
