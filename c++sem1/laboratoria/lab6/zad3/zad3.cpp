# include <iostream>
#include <cstdio>
using namespace std;
bool czy_potega(unsigned int n)
{
    if(n&(n-1))
        return false;
    else
        return true;

}
int main()
{
    unsigned int rgb;
    cout<<"podaj kolor";
    //scanf("%x",&rgb); //c
    cin>>hex>>rgb; //c++
    int b=rgb & 0x0000ff;
    int g=(rgb&0x00ff00)>>8;
    int r=(rgb&0xff0000)>>16;
    cout<<"RGB "<<hex<<rgb<<" b "<<dec<<b<<" g "<<dec<<g<<" r "<<dec<<r;
}
