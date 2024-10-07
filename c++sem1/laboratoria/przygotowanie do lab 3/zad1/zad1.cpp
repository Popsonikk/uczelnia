#include <iostream>

using namespace std;

int main()
{
    int a;
    cout<<"Podaj liczbe calkowita dodatnia a"<<endl;
    cin>>a;
    cout<<"wszystkie liczby calkowite z przedzialu <0;"<<a<<") to: ";
    for(int i=0;i<a;i++)
    {
        cout<<i<<' ';
    }

}
