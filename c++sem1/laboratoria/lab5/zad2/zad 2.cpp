#include <iostream>
using namespace std;
int kwadrat(int a)
{
    int pow, suma=0;
    while(a>0)
    {
        pow=a%10;
        a/=10;
        suma=pow*pow;
    }
    return suma;
}
bool wesola(int a)
{
    int fast=a,slow=a;
    do
    {
        slow=kwadrat(slow);
        fast=kwadrat(kwadrat(fast));
    }
    while(fast!=slow);
    if(fast==1)
        return true;
    else
        return false;
}

int main()
{
    int a;
    cout<<"podaj a  ";
    cin>>a;
    if(wesola(a)==1)
        cout<<"wesola";
    else
        cout<<"smutna";
}
