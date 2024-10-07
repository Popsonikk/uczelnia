#include <iostream>
using namespace std;
int kwadrat(int a,int b)
{
    if(a==0)
        return 1;
    if(a==1)
        return b;
    return 2*b*kwadrat(a-1,b)-kwadrat(a-2,b);
}


int main()
{
    int a,b;
    cout<<"podaj a b ";
    cin>>a>>b;
    cout<<kwadrat(a,b);
    return 0;

}
