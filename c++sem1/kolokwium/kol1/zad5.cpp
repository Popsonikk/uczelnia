#include <iostream>
using namespace std;
unsigned int rek( unsigned int m,unsigned int k)
{
    if(m<=0) return 0;
    else if(m<10) return k+rek(m-1,k);
    else return 2*rek(m-1,k)+rek(m-2,k);

}
int main()
{
    unsigned int m,k;
    cin>>m>>k;
    cout<<rek(m,k);
    return 0;
}
