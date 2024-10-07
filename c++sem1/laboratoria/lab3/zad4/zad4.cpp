#include <iostream>
using namespace std;
int main()
{
    int a,b,c;
    cout<<"podaj a,b,c ";
    cin>>a>>b>>c;
    for(int i=100;i<1000;i++)
    {
        bool a1=false,b1=false,c1=false,d1=false;
        int reszta=0;
        int j=i;
        while(j)
        {
            reszta=j%10;
            if(reszta==a)
                a1=true;
            if(reszta==b)
                b1=true;
            if(reszta==c)
                c1=true;
            if((reszta!=a)&&(reszta!=b)&&(reszta!=c))
                d1=true;
            j/=10;
        }
            if((a1==true)&&(b1==true)&&(c1==true)&&(d1==false))
                cout<<i<<' ';
    }
    return 0;
}


