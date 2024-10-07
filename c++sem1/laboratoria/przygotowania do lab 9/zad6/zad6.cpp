#include <iostream>
using namespace std;
typedef int (*fwsk)(int,int);
int licz(int a,int b)
{
    return a%10==b?1:0;
}
int cyfra(int a,int b,fwsk wsk)
{
    int n=0;
    while(a)
    {
        n+=wsk(a,b);
        a/=10;
    }
    return n;
}

int main()
{
    int a=123436,b=3;
    fwsk wsk=licz;
    cout<<"liczba cyfr "<<cyfra(a,b,licz);
}
