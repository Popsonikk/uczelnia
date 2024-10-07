#include <iostream>
using namespace std;
int ciag(int n)
{
    if(n==1)
        return 1;
    else if(n==2)
            return 1;
    else
        return ciag(n-1)+2*ciag(n-2)+3;

}
void rek(int n)
{
    cout<<ciag(n)<<" ";
    if(n>1)
        rek(n-1);


}
int main()
{
    int k;
    cout<<"podaj dlugosc ";
    cin>>k;
    rek(k);
    return 0;
}
