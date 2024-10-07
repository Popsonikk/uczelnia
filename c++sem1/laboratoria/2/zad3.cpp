#include<iostream>
using namespace std;
void refe(float& a, float& b)
{
  float c=a;
  a=b;
  b=c;

}
int main()
{
    float a,b;
    cout<<"podaj a, b "<<endl;
    cin>>a>>b;
    refe(a,b);
    cout<<"a wynosi "<<a<<" b wynosi "<<b;
}
