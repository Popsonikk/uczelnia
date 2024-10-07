#include <iostream>
using namespace std;
int f1(int v)
{
    int suma=0;
    while(v>0)
    {
        if(v%2==0)
        {
            suma+=1;
            suma<<=1;
        }
        v/=2;
    }
    return suma;
}
int main()
{
    int v=9;
    cout<<f1(v);
    return 0;
}
