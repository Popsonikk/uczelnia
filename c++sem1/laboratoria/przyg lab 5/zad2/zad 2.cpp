#include<iostream>
using namespace std;
bool suma(float a, float b,float c)
{
    if((a+b>c)&&(a+c>b)&&(b+c>a))
        return true;
    else
        return false;
}
int main()
{
    float a,b,c;
    cout<<"podaj a, b, c "<<endl;
    cin>>a>>b>>c;
    if(suma(a,b,c)==1)
        cout<<"da sie zbudowaæ trójk¹t";
    else
        cout<<"nie da sie zbudowaæ trójk¹ta";
}
