#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
using namespace std;
void tak(int** wsk,int a)
{

    for(int i=0;i<a;i++)
    {
        for(int j=0;j<=i;j++)
            wsk[i][j]=(i+1)*(j+1);
    }
}
void wyswietl(int **wsk ,int a)
{
     for(int i=0;i<a;i++)
    {
        for(int j=0;j<=i;j++)
            cout<<wsk[i][j]<<' ';
        printf("\n");
    }
}
int main()
{
    int a=10;
    int** wsk;
    wsk =new int*[a] ;
    for(int i=0;i<a;i++)
        wsk[i]=new int[a-i];



    tak(wsk,10);
    wyswietl(wsk,10);
    for(int i=0;i<a;i++)
        delete[]wsk[i];
    delete[]wsk;
    return 0;
}
