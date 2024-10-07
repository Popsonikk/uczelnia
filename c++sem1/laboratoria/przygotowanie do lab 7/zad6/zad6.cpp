#include <iostream>
using namespace std;
void tak(int* a)
{
    *a+=3;
}
int main()
{
    int a;
    cout<<"podaj liczbe ";
    cin>>a;
    int* wsk =new int ;
    wsk=&a;
    tak(wsk);
    cout<<"wartosc zmiennej "<<*wsk;
    delete wsk;
    return 0;
}
