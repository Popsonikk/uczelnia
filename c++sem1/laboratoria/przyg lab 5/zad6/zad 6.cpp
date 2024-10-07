#include<iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
using namespace std;
void rosnacy(int tab[],int a,int index,int amax,int n,int i)
{
    if(tab[i]>tab[i+1])
        a++;
    else
    {
        if(amax<a)
        {
            amax=a;
            index=i-a-2;
            a=0;
        }
    }
    i++;
    if(i<n)
        rosnacy( tab, a, index, amax, n, i);
    else
        cout<<"ciag rosnacy: indeks "<<index<<" dlugosc "<<amax<<endl;

}
void staly(int tab[],int a,int index,int amax,int n,int i)
{
     if(tab[i]==tab[i+1])
        a++;
    else
    {
        if(amax<a)
        {
            amax=a;
            index=i-a-2;
            a=0;
        }
    }
    i++;
    if(i<n)
        staly(tab, a, index, amax, n, i);
    else
        cout<<"ciag staly: indeks "<<index<<" dlugosc "<<amax<<endl;

}
void malejacy(int tab[],int a,int index,int amax,int n,int i)
{
     if(tab[i]<tab[i+1])
        a++;
    else
    {
        if(amax<a)
        {
            amax=a;
            index=i-a-2;
            a=0;
        }
    }
    i++;
    if(i<n)
        malejacy(tab, a, index, amax, n, i);
    else
        cout<<"ciag malejacy: indeks "<<index<<" dlugosc "<<amax<<endl;

}

int main()
{
    srand( time( NULL ) );
    int n=25,tab[25]={0},index=0,a=1,amax=0,i=0;
    for(int j=0;j<n;j++)
        tab[j]=rand()%15;
    for(int j=0;j<n;j++)
        cout<<tab[j]<<" ";
    cout<<endl;
    rosnacy( tab, a, index, amax, n, i);
    staly(tab, a, index, amax, n, i);
    malejacy(tab, a, index, amax, n, i);
}
