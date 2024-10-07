#include<iostream>
using namespace std;

bool condition(int n)
{
    int cyfry[10]={};
    int a=0,x=n;
    bool czy=true;
    while(x)
    {
        a=x%10;
        cyfry[a]++;
        x/=10;
    }
    for(int i=0;i<10;i++)
    {
        if(cyfry[i]>1)
        {
            czy=false;
            break;
        }
    }
    return czy;
}
int action(int n)
{
    int x=n,a=0;
    while(x)
    {
        a*=10;
        a=a+x%10;
        x/=10;
    }
    return a;

}
void modify_array(int tab[],int n,void(*f1)(int),bool(*f2)(int))
{

}
int main()
{
    int n=123;
    int x =1223;
    cout<<condition(n)<<endl;
    cout<<condition(x)<<endl;
    action(x);
}

