# include <iostream>
using namespace std;
bool czy_potega(unsigned int n)
{
    if(n&(n-1))
        return false;
    else
        return true;

}
int main()
{
    unsigned int n;
    printf("podaj n ");
    cin>>n;
    if(czy_potega(n))
        cout<<"potega";
    else
        cout<<"niepotega";
}
