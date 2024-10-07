#include <iostream>
using namespace std;
bool czy_pierwsza(int x[])
{
    bool czy=true;
    for(int i=0,j=9;i<j;i++,j--)
    {
        if(x[i]!=x[j])
        {
            czy=false;
            break;
        }
    }
    return czy;
}
int main()
{
    int x[10];
    for(int i=0;i<10;i++)
    {
       printf("podaj %d indeks \n",i);
       cin>>x[i];
    }

    czy_pierwsza(x)? printf("symetryczna"):printf("niesymetryczna");
}
