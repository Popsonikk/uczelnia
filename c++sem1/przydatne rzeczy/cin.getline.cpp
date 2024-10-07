#include <iostream>
#include <cstdlib>
using namespace std;

int main()
{
    char tab[100];
    int i=0;
    cout<<"podaj tekst ";
    cin.getline(tab,100);
    while(tab[i])
    {
        cout<<tab[i];
        i++;
    }



}
