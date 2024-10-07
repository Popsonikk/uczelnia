#include <iostream>
using namespace std;
void rek(int n,int i,int suma)
{
    suma*=i;
    i++;
    if(i<=n)
        rek(n,i,suma);
    printf("silnia wynosi %d\n",suma);

}
int ite(int n,int suma)
{
    for(int i=1;i<=n;i++)
        suma*=i;
    return suma;
}
int main()
{
    int n,i=1,suma=1;
    cout<<"podaj n ";
    cin>>n;
    rek(n,i,suma);
    printf("silnia wynosi %d\n",ite(n,suma));
}
