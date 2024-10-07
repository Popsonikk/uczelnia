#include <iostream>
#include <cmath>
using namespace std;
float cos(int x,int y)
{
    return x/sqrt((float)x*(float)x+(float)y*(float)y);
}
int main()
{
    int x ,y;
    cout<<"podaj x y ";
    cin>>x>>y;
    cout<<"cosl wynosi "<<cos(x,y);
}
