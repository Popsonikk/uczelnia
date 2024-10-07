#include <iostream>
using namespace std;
float bmi(float wzrost, float masa)
{
    return masa/(wzrost*wzrost);
}
void wyswietl(float n)
{
    if(n<18.5)
        cout<<"niedowaga";
    else if(n<25)
        cout<<"norma";
    else if(n<30)
        cout<<"nadwaga)";
    else
        cout<<"otylosc";
}
int main()
{
    float m,h;
    printf("podaj mase(kg) i wzrost(m) \n");
    cin>>m>>h;
    printf("twoje BMI wynosi %f \n",bmi(h,m));
    wyswietl(bmi(h,m));
}
