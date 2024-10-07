#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
using namespace std;
void tak(int* a,int n)
{
    int i=0;
    srand(time(NULL));
    while(i<n)
    {
        *(a+i)=rand()%10;
        i++;
    }
}
void wyswietl(int *a ,int n)
{
    int i=0;
    while(i<n)
    {
        cout<<*(a+i)<<' ';
        i++;

    }
}
int main()
{
    int a;
    cout<<"podaj liczbe ";
    cin>>a;
    int* wsk =new int[a] ;
    tak(wsk,a);
    wyswietl(wsk,a);
    delete[]wsk;
    return 0;
}
