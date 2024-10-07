#include <iostream>
using namespace std;
float poly_area(float a,float b,float c,float d,float x0,float xn)
{
   float area=0,h=0;
   while(x0<=xn)
   {
        area+=0.001*(a*x0*x0*x0+b*x0*x0+c*x0+d);
        x0+=0.001;
   }
   return area;
}
int main()
{
    float a,b,c,d,x0,xn;
    cin>>a>>b>>c>>d>>x0>>xn;
    cout<<poly_area(a,b,c,d,x0,xn);
    return 0;
}
