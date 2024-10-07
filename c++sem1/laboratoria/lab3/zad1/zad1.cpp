#include <iostream>
using namespace std;
int main()
{
    int n,reszta=0;
    cout<<"podaj n ";
    cin>>n;
    while(n)
    {
        reszta=n%10;
        n/=10;
        cout<<reszta;
    }

}
