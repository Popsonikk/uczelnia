#include <iostream>
void f(void *wsk , int prtsize)
{
    if(prtsize==1)
        *wsk=(*char)prtsize+1;
    else if (prtsize==4)
        *wsk=(*int )prtsize+1;
    std::cout<<*wsk;
}
int main ()
{
    void *wsk=nullptr;
    int n=4;
    f(wsk,n);
}
