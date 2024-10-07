#include <iostream>
using namespace std;
double kwadrat(double x,int k)
{
    if(k==0)
        return 1;
    if(k==1)
        return x;
    double t0=1, t1=x,tmt1=0;
    for(int i=2;i<=k;i++)
    {
        tmt1=t1;
        t1=2*x*t1-t0;
        t1=tmt1;
    }
    return t1;

}


int main()
{
    int a,b;
    cout<<"podaj a b ";
    cin>>a>>b;
    cout<<kwadrat(a,b);
    return 0;

}
