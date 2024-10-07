#include <iostream>
using namespace std;
int main()
{
    int n,reszta=0,liczba=0,mod=1;
    cout<<"podaj n ";
    cin>>n;
    while(n)
    {
        reszta=n%2;

        liczba+=reszta*mod;
        mod*=10;

        n/=2;


    }
    cout<<liczba;

}
