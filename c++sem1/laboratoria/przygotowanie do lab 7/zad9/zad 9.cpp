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
        *(a+i)=rand()%10+1;
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
void nieparzyste(int *wsk,int* arr ,int n)
{
    int i=0,j=0;
    while(i<n)
    {
        if(*(wsk+i)%2==1)
        {
            *(arr+j)=*(wsk+i);
            j++;
        }
        i++;
    }
}
void parzyste(int *wsk,int* arr ,int n)
{
    int i=0,j=0;
    while(i<n)
    {
        if(*(wsk+i)%2==0)
        {
            *(arr+j)=*(wsk+i);
            j++;
        }
        i++;
    }
}
int main()
{
    int a;
    cout<<"podaj liczbe ";
    cin>>a;
    int* wsk =new int[a] ;
    int* arr =new int[a] ;
    int* tab =new int[a] ;
    tak(wsk,a);
    wyswietl(wsk,a);
    cout<<endl;
    parzyste(wsk,arr,a);
    wyswietl(arr,a);
    cout<<endl;
    nieparzyste(wsk,tab,a);
    wyswietl(tab,a);
    delete[]wsk;
    delete[]tab;
    delete[]arr;
    return 0;
}
