#include <iostream>
using namespace std;
int bitsUsed(int number)
{
    int bits=0;
    while(number)
    {
        number>>=1;
        bits++;
    }
    return bits;
}
char* decimalToBinaty(int number)
{

    int bits=bitsUsed(number);
    char* binary = new char[bits];
    for(int i=bits-1;i>=0;i--)
    {
        binary[i]=(number&1)?'1':'0';
        number>>=1;
    }
    return binary;
}
int main()
{
    char* binary = decimalToBinaty(16);
    for(int i=0;i<10;i++)
    {
        cout<<binary[i];
    }
    delete[]binary;
    return 0;
}
