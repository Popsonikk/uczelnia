#include<iostream>
using namespace std;
int suma(int a, int b)
{
    return a+b;
}
int main()
{
    int a,b;
    cout<<"podaj a i b "<<endl;
    cin>>a>>b;
    cout<<"suma wynosi "<<suma(a,b);
}
