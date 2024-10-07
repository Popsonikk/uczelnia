#include <iostream>
#include <cmath>
using namespace std;
float dl(float x1,float y1, float x2,float y2)
{
    return sqrt(pow(x2-x1,2)+pow(y2-y1,2));
}
bool czy_trojkat(float a,float b,float c)
{
    if(a+b>c&&a+c>b&&b+c>a)
        return true;
    else
        return false;
}
float stosunek(float a,float b,float c)
{
    if(a>=b)
    {
        if(b>=c)
            return a/c;
        else
            return a/b;
    }
    else if(b>=a)
    {
        if(a>=c)
            return b/c;
        else
            return b/a;
    }
    else if(c>=a)
    {
        if(a>=b)
            return c/b;
        else
            return c/a;
    }
}
int main()
{
    float x1,y1,x2,y2,x3,y3;
    cout<<"podaj 3 punkty "<<endl;
    cin>>x1>>y1>>x2>>y2>>x3>>y3;
    float a=dl(x1,y1,x2,y2);
    float b=dl(x1,y1,x3,y3);
    float c=dl(x3,y3,x2,y2);
    cout<<"boki wynosz¹ "<<a<<' '<<b<<' '<<c<<endl;
    if(czy_trojkat(a,b,c))
        printf("stosunek boków wynosi %f ",stosunek(a,b,c));
    else
        printf("trojkat nie istnieje");

}
