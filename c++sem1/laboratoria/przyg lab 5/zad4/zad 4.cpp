#include<iostream>
using namespace std;
void refe(int n, int suma,int a)
{
    suma*=a;
    a++;
    if(a<=n)
        refe(n,suma,a);
    else
        cout<<"silnia wynosi "<<suma;


}
int silnia(int n,int suma)
{
    for(int i=1;i<=n;i++)
        suma*=i;
    return suma;
}
int main()
{
    int n,suma=1,a=1;
    cout<<"podaj n "<<endl;
    cin>>n;
    refe(n,suma,a);
    printf("\n");
    cout<<"silnioa wynosi "<<silnia(n,suma);
}
