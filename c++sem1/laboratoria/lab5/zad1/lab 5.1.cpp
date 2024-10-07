#include <iostream>
using namespace std;
int NWD(int a, int b)
{
    while(a!=b)
    {
        if(a>b)
            a-=b;
        else
            b-=a;
    }
    return a;
}
int NWW(int a,int b)
{
   return a*b/ NWD(a,b);
}
int main()
{
    int a,b;
    cout<<"podaj a b ";
    cin>>a>>b;
    cout<<"NWD "<<NWD(a,b)<<endl;
    cout<<"NWW "<<NWW(a,b)<<endl;
}
