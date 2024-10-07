#include <iostream>
#include <cstring>
using namespace std;
void f( char arr[][10],int n,int m)
{
    long int *tab=new long int[n];
    for(int i=0;i<n;i++)
    {
        char *wsk=&arr[i][m];
        tab[i]=strtol(&arr[i][0],&wsk,10);
        cout <<tab[i]<<' ';
    }
}
int main()
{
    char arr[5][10]={{"LRY 1234"},{"LU 87654"},{"WA 1234"},{"LRY 888"},{"LU 999"}};
    f(arr,5,10);
}
