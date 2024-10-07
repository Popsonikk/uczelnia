#include <iostream>

using namespace std;

int main()
{
    float a,suma=0;
    while(1)
    {
        cout<<"Podaj liczbe ";
        cin>>a;
        suma+=a;
        if(suma>100)
            break;
    }
    cout<<"Suma jest wieksza od 100 o "<<suma-100;
    return 0;
}
