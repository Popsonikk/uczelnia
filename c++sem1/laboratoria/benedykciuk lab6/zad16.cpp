#include <iostream>
int wiosna(int n)
{
    return n%2?n+=((n-1)/2):n+=n/2;
}
int jesien(int n)
{
    return n>10?n-10:0;
}
int zima(int n)
{
    return n*0.6;
}
int lata(int &n,int pora,int rok)
{
    for(int i=1;i<rok;i++)
    {
       n= wiosna(n);
       n= jesien(n);
       n= zima(n);
    }
    n=wiosna(n);
    if(pora==2||pora==3)
        n=jesien(n);
    if(pora==3)
        n=zima(n);
    return n;
}
int main()
{
    int n,rok,pora;
    printf("podaj n ,rok ,pore");
    //scanf("%d,%d,%d",&n,&rok,&pora);
    std::cin>>n>>rok>>pora;
    std::cout<<"wynik "<<lata(n,pora,rok);


}
