#include<iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
const int n=5;
using namespace std;
bool refe(float tab[][n], int n)
{
    int suma1=0,suma2=0;
    for(int i=0;i<10;i++)
    {
        for(int j=0;j<n;j++)
        {
            suma1+=tab[j][i];
        }
        if(suma1<suma2)
            return false;
        suma2=suma1;

    }
    return true;
}
int main()
{

    float tab[10][n];
    srand( time( NULL ) );

    for(int j=0;j<10;j++)
    {
        for(int i=0;i<n;i++)
            tab[j][i]=rand()%25;
    }

    for(int j=0;j<10;j++)
    {
        for(int i=0;i<n;i++)
            cout<<tab[j][i]<<" ";
        cout<<endl;
    }
    cout<<endl;
    if(refe(tab,n)==1)
        cout<<"prawda";
    else
        cout<<"falsz";
}
