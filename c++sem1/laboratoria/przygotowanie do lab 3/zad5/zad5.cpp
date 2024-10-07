#include <iostream>

using namespace std;

int main()
{
    float a,suma=0;
    while(1)
    {
        cout<<"Podaj liczbe ";
        cin>>a;
        if(a!=0)
            suma+=a;
        else
            break;
    }
    cout<<"Suma powyzszych liczb wynosi "<<suma;
    return 0;
}
