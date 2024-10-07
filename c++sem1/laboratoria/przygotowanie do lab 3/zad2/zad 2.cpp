#include <iostream>

using namespace std;

int main()
{
    int a;
    cout<<"Podaj liczbe calkowita a"<<endl;
    cin>>a;
    if(a>=0)
    {
        cout<<"wszystkie liczby calkowite z przedzialu <0;"<<a<<") to: ";
        for(int i=0;i<a;i++)
        {
            cout<<i<<' ';
        }
    }
    else
    {
        cout<<"wszystkie liczby calkowite z przedzialu ("<<a<<";0> to: ";
        for(int i=a+1;i<=0;i++)
        {
            cout<<i<<' ';
        }
    }
}
