#include <iostream>
#include <cstdlib>

using namespace std;

int f(char * napis)
{
    char *pEnd = napis;
    int suma = 0;
    int system = strtol(pEnd, &pEnd, 10);
    int liczba = strtol(pEnd + 1, &pEnd, system);
    suma += liczba;
    bool znak = false;
    while(*(pEnd+1))
    {
        if(pEnd[2] == '+') {
            znak = true;
        } else if(pEnd[2] == '-') {
            znak = false;
        }
        //cout<<system<<" "<<liczba<<endl;
        system = strtol(pEnd + 4, &pEnd, 10);
        liczba = strtol(pEnd + 1, &pEnd, system);
        if(znak) suma += liczba;
        else suma -= liczba;
    }

    return suma;
}

int main()
{
    cout<<f("14(4C) + 8(7331) - 3(121001)");
    return 0;
}
