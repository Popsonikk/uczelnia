#include <iostream>
using namespace std;
bool czy_pierwsza(int x)
{
    bool czy=true;
    for(int i=2;i<x;i++)
    {
        if(x%i==0)
        {
            czy=false;
            break;
        }
    }
    return czy;
}
int main()
{
    int x;
    cout<<"podaj x ";
    cin>>x;
    czy_pierwsza(x)? printf("pierwsza"):printf("zlozona");
}
