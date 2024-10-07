#include <iostream>
using namespace std;
void przedzial(int n,int i)
{
    printf(" %d",i);
    i++;
    if(i<=n)
        przedzial(n,i);

}
int main()
{
    int n,i=1;
    cout<<"podaj n ";
    cin>>n;
    przedzial(n,i);
}
