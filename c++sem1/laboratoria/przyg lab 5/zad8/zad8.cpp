#include<iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
using namespace std;
void refe(float tab[], int n,int a,int b)
{
     if(tab[a]==0)
     {
         tab[a]=tab[b];
         tab[b]=0;
         b--;
     }
     a++;
     if(a<b)
        refe(tab,n,a,b);
     else
     {
         for(int j=0;j<n;j++)
            cout<<tab[j]<<" ";
     }
}
int main()
{
    const int n=20;
    float tab[n];
    int a=0,b=n-1;
    srand( time( NULL ) );

    for(int j=0;j<n;j++)
        tab[j]=rand()%5;
    for(int j=0;j<n;j++)
        cout<<tab[j]<<" ";
    cout<<endl;
    refe(tab,n,a,b);
}
