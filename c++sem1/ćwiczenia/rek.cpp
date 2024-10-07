#include <iostream>
using namespace std;
int rek(int x)
{
    if(x==0)
        return 0;
    else if(x==1)
        return 6;
    else
        return 3+rek(x-1);
}
int main()
{
    int x;
    cout<<"podaj x ";
    cin>>x;
    cout<<"x wyraz wynosi"<<rek(x);
}
