#include <iostream>
int main ()
{
    int a=72, m=365 ,i=0;
    while(1)
    {
        ++i;
        if((a*i)%m==1)
        {
            break;
        }

    }
    printf("reszta %d",i);
}
