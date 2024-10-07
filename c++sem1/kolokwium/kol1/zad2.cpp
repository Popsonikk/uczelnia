#include <iostream>
#include <cmath>
using namespace std;
void f1(int m,int f,int n,float r)
{
    int wiek[10][2];
    for(int i=0;i<n;i++)
    {
        if(i==0)
        {
            wiek[0][0]=m;
            wiek[0][1]=f;
        }
         if(i>=5)
        {
            m-=wiek[i-5][0];
            f-=wiek[i-5][1];
        }
        m-=f;//zap³odnienie
        if(m<0)
            m=0;
        wiek[i+1][0]=f*(1/(1+r))*0.3;
        wiek[i+1][1]=f*(1/(1+r));
        f+=f*(1/(1+r));
        m+=f*(1/(1+r))*r;


        cout<<"m "<<m<<" f "<<f<<endl;
    }
}
int main()
{
    int m=10,f=30,n=10;
    float r=0.3;
    f1(m,f,n,r);
}
