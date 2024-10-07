#include <iostream>

using namespace std;

int main()
{
    int a,b;
    float suma=0;
    cout<<"Podaj liczbe calkowita a ";
    cin>>a;


    for(int i=1;i<=a;i++)
    {
        cout<<"podaj liczbe"<<i<<' ';
        cin>>b;
        suma+=b;
    }
    suma+=a;
    cout<<"srednia arytmetyczna wynosi "<<suma/(a+1);
}


