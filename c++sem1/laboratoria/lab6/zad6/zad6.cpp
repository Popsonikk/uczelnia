#include <iostream>
using namespace std;
void set(unsigned char arr[],unsigned int n,bool wartosc)
{
    int indeks_bit=n%8;
    int indeks_tab=n/8;
    if(wartosc)
        arr[indeks_tab]|=(1<<indeks_bit);
    else
        arr[indeks_tab]&=~1<<indeks_bit;
}
bool get(unsigned char arr[],unsigned int n)
{
    int indeks_bit=n%8;
    int indeks_tab=n/8;
    return arr[indeks_tab]&(1<<indeks_bit);
}
int main()
{
    unsigned char arr[3]={0};
    set(arr,5,true);
    set(arr,10,true);
    set(arr,20,true);
    for(int i=0;i<24;i++)
        cout<<get(arr,i)<<" ";


    return 0;
}
