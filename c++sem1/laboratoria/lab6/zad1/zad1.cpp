# include <iostream>
using namespace std;
bool czy_parzysta(unsigned int n)
{
    if(n&1)
        return false;
    else
        return true;

}
int main()
{
    unsigned int n;
    printf("podaj n ");
    cin>>n;
    if(czy_parzysta(n))
        cout<<"parzysta";
    else
        cout<<"nieparzysta";
}
