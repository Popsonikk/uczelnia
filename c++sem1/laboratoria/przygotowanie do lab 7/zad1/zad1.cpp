#include <iostream>
using namespace std;
int zmien(int* a)
{
    return *a+4;
}
int main()
{
    int a;
    cout<<"podaj liczbe calkowita ";
    cin>>a;
    int* n=&a;
    printf("wartosc zmiennej %d ",zmien(n));

}
