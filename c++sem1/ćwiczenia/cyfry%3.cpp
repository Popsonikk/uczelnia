#include <iostream>
using namespace std;
int podzielne(int x)
{
    int a=0,y=0;
    while(x)
    {

        if((x%10)%3==0&&x%10!=0)
            a++;
        x/=10;
    }
    return a;
}
int main()
{
    int x;
    cout<<"podaj x ";
    cin>>x;
    cout<<"liczba cyfr%3 "<<podzielne(x);
}
