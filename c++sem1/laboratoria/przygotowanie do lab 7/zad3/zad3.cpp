#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <ctime>
using namespace std;
void zmien(int* a,int* b)
{
    int i=0;
   while(a+i<=b)
   {
       cout<<*(a+i)<<' ';
       i++;
   }
}
int main()
{
    int tab[10];
    srand(time(NULL));
    for(int i=0;i<10;i++)
        tab[i]=rand()%10;
    for(int i=0;i<10;i++)
        cout<<tab[i]<<' ';
    printf("\n");
    zmien(tab,&(tab[9]));

}
