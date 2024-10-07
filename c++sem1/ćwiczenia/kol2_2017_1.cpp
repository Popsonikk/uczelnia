#include <iostream>
float* f(float *a,float *b,float *c)
{

  *c=*a * *b;

    return c;

}
int main()
{
    float a,b,c=0;
    printf("podaj a b ");
    std::cin>>a>>b;
    float *wynik=f(&a,&b,&c);
    std::cout<<*wynik;
}
