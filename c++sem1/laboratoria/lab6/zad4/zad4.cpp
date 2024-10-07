# include <iostream>
#include <cstdio>
using namespace std;
int chmod(int priv, const char change[])
{
    if(change[0]>='0'&&change[0]<='7')
    {
        priv =0;
        for(int i=0;i<3;i++)
        {
            priv=priv<<3;//priv<<=3
            priv|=change[i]-'0';
        }
    }
    else
    {
        int bit=0;
        bool allow;
        switch(change[0])
        {
            case 'u':bit<<=6; break;
            case 'g':bit<<=3; break;
            case 'a':bit<<=0; break;
            default: return priv;
        }
         switch(change[1])
        {
            case '+':allow=true; break;
            case '-':allow=false; break;
            default: return priv;
        }
         switch(change[2])
        {
            case 'r':bit<<=2; break;
            case 'w':bit<<=1; break;
            case 'x':bit<<=0; break;
            default: return priv;
        }
        if(allow)
            priv|=bit;
        else
            priv&=~bit;
    }
    return priv;
}
void print(int priv)
{
    char name[3]={'r','w','x'};
    for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                cout<<(priv&256?name[j]:'-');
                priv<<=1;
            }
        }
        cout<<endl;
}
int main()
{
    int priv=0;
    priv=chmod(priv,"653");
    print(priv);
}
