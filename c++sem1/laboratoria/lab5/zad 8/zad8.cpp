#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
using namespace std;
void sortowanie(int tab[],int n)
{
   for(int i=0;i<n-1;i++)
   {
       for(int j=0;j<n-1;j++)
       {
           if(tab[j]>tab[j+1])
                swap(tab[j],tab[j+1]);
       }
   }
   for(int j=0;j<n;j++)
        cout<<tab[j]<<" ";
}


int main()
{
    const int n=20;
    int tab[n];

    srand( time( NULL ) );

    for(int j=0;j<n;j++)
        tab[j]=rand()%15;
    for(int j=0;j<n;j++)
        cout<<tab[j]<<" ";
    cout<<endl;
    sortowanie(tab,n);
    return 0;

}
