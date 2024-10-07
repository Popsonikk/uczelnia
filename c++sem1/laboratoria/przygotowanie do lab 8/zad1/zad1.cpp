#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
using namespace std;
void tak(int** wsk,int a,int b)
{

    srand(time(NULL));
    for(int i=0;i<a;i++)
    {
        for(int j=0;j<b;j++)
            wsk[i][j]=rand()%10;
    }
}
void wyswietl(int **wsk ,int a,int b)
{
     for(int i=0;i<a;i++)
    {
        for(int j=0;j<b;j++)
            cout<<wsk[i][j]<<' ';
        printf("\n");
    }
}
int main()
{
    int a,b;
    cout<<"podaj 2 liczbe ";
    cin>>a>>b;
    int** wsk;
    wsk =new int*[a] ;
    for(int i=0;i<a;i++)
        wsk[i]=new int[b];

    srand(time(NULL));
   /* for(int i=0;i<a;i++)
    {
        for(int j=0;j<b;j++)
            wsk[i][j]=rand()%10;
    }
    for(int i=0;i<a;i++)
    {
        for(int j=0;j<b;j++)
            cout<<wsk[i][j]<<' ';
        printf("\n");
    }*/

    tak(wsk,a,b);
    wyswietl(wsk,a,b);
    for(int i=0;i<a;i++)
        delete[]wsk[i];
    delete[]wsk;
    return 0;
}
