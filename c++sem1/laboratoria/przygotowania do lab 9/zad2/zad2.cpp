#include <iostream>
using namespace std;
int max(int a,int b)
{
    return a>b?a:b;
}
int min(int a,int b)
{
    return a>b?b:a;
}
int solt(int tab[],int n, int(*wsk)(int,int))
{
    int ex=tab[0];
    for(int i=0;i<n;i++)
        ex=wsk(ex,tab[i]);
    return ex;
}
int main()
{
    int tab[]={2,4,3,1,9,3,2,6,8};
    int n=sizeof(tab)/sizeof(tab[0]);
    int (*wsk)(int a,int b)=min;
    cout<<solt(tab,n,wsk);
}
