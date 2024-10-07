#include <iostream>
using namespace std;
int kwadrat(int t0, int t1 ,int x,int k)
{
    if(k==0)
        return t0;

    return kwadrat(t1,2*x*t1-t0,x,k-1);
}


int main()
{
   // int a,b;
   // cout<<"podaj a b ";
  //  cin>>a>>b;
    cout<<kwadrat(1,5,5,3);
    return 0;

}
