#include<iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
using namespace std;
int refe(float tab[], int n)
{
    int max1=0,max2=0;
    for(int i=0;i<n;i++)
    {
        if(tab[i]>max1)
        {
            max2=max1;
            max1=tab[i];
        }
        else if(tab[i]>max2)
            max2=tab[i];
    }
    return max2;
}
int main()
{
    const int n=20;
    float tab[n];
    srand( time( NULL ) );

    for(int j=0;j<n;j++)
        tab[j]=rand()%25;
    for(int j=0;j<n;j++)
        cout<<tab[j]<<" ";
    cout<<endl;
    cout<<"max2 wunosi "<<refe(tab,n);
}
