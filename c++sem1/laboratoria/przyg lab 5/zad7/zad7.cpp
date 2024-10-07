#include<iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
using namespace std;
void refe(float tab[], int n,int a,int b)
{
     for(int j=0;j<n;j++)
        {
            if((j<a)||(j>b))
                tab[j]=0;
        }
        for(int j=0;j<n;j++)
        cout<<tab[j]<<" ";

}
int main()
{
    const int n=50;
    float tab[n];
    int a,b;
    cout<<"podaj a  b ";
    cin>>a>>b;
    srand( time( NULL ) );

    for(int j=0;j<n;j++)
        tab[j]=rand()%15;
    for(int j=0;j<n;j++)
        cout<<tab[j]<<" ";
    cout<<endl;
    refe(tab,n,a,b);


}
