#include <iostream>
using namespace std;
int main()
{
    int n,reszta=0,liczba=0;
    cout<<"podaj n ";
    cin>>n;
    while(n)
    {
        reszta=n%10;
        liczba+=reszta;
        n/=10;
        if(n!=0)
            liczba*=10;


    }
    cout<<liczba;

}
