#include<iostream>
using namespace std;
void refe(int n, int suma,int a,int suma1,int b)
{
    b=suma;
    suma+=suma1;
    suma1=b;
    a++;
    if(a<=n-2)
        refe(n,suma,a,suma1,b);
    else
        cout<<"wyraz "<<n<<" ciagu wynosi "<<suma;


}
int ciag(int n,int suma,int suma1,int b)
{
    for(int i=1;i<=n-2;i++)
    {
        b=suma;
        suma+=suma1;
        suma1=b;
    }
    return suma;
}
int main()
{
    int n,suma=1,a=1,suma1=1,b=0;
    cout<<"podaj n "<<endl;
    cin>>n;
    refe(n,suma,a,suma1,b);
    printf("\n");
    cout<<"ciag wynosi "<<ciag(n,suma,suma1,b);
}
