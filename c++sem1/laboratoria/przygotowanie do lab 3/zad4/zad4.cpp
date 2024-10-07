#include <iostream>

using namespace std;

int main()
{
    int a,b,Max;
    cout<<"Podaj liczbe calkowita a ";
    cin>>a;
    Max=a;
    for(int i=1;i<=a;i++)
    {
        cout<<"podaj liczbe"<<i<<' ';
        cin>>b;
        if(b>Max)
            Max=b;
    }
    cout<<"najwieksza liczba wynosi "<<Max;
}
