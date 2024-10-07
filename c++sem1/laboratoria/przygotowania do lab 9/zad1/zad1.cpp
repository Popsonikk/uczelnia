#include <iostream>
using namespace std;
typedef int (*fwsk)(int,int);
int dod(int a,int b)
{
    return a+b;
}
int ode(int a,int b)
{
    return a-b;
}
int main()
{
    int a=4,b=3;
    fwsk f1=dod;
    fwsk f2=ode;
    cout<<f1(a,b)<<' ';
    cout<<f2(a,b);
}
