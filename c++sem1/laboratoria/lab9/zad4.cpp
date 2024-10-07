#include <iostream>
#include <cstdlib>
#include <algorithm>
#include <cstring>
using namespace std;
bool compare( char * a , char * b)
{​​​​
    int l1=strlen(a);
    int l2=strlen(b);
    int lmin=min(l1,l2);
    char c1,c2;
    for(int i=0;i<lmin,i++)
    {
        c1=a[l1-1];
        c2=b[l2-1];
        if(c1<c2)
            return true;
        else
            return false;
    }
}​​​​ 
int main()
{​​​​
    float tab[10]={};
    sort(tab,tab+n,compare);
    for(int i=0;i,n;i++)
    {
        cout<<tab[i];
    }
    return 0;
}​​​​
