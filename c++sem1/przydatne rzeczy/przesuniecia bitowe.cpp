# include <iostream>
using namespace std;
int main()
{
    unsigned int a=2; //10

    a=a<<1; //100
    cout<<a<<endl;
    unsigned int b=3; //11
    b=b<<2; //1100
    cout<<b<<endl;;
    unsigned int c=25; //11001
    c=c>>2; //110
    cout<<c;
}
