#include <iostream>
using namespace std;
void zmien(float* a,float* b)
{
    int n=*a;
    *a=*b;
    *b=n;
}
int main()
{
    float a,b;
    cout<<"podaj 2 liczbe rzeczywisye ";
    cin>>a>>b;
    zmien(&a,&b);
    printf("zamienione zmienna a=%f b=%f",a,b);

}
