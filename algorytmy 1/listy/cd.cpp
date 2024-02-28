#include <iostream>
#include <string>

int main()
{
    int *a=new int [5];
    a[0]=1;
    a[1]=2;
    a[2]=3;
    a[3]=4;
    a[4]= 5;
    int *b=new int[4];
    memcpy(b,a,2*sizeof(int));
    memcpy(b+2,a+3,2*sizeof(int));
    for(int i=0;i<4;i++)

        std::cout<<b[i]<<' ';




}
