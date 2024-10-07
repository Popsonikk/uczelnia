#include <iostream>
#include <cmath>
using namespace std;
int main()
{
    int maxY=80,maxX=25;
    float a,b;
    cout<<"podaj a, b";
    cin>>a>>b;
    for(int y=maxY-1;y>=0;y--)
    {
        int xmin=round((y-0.5-b)/a);
        int xmax=round((y+0.5-b)/a);
       // int xvalue=(y-b)/a;
        if((xmin>0)&&(xmin<maxY-1)&&(xmax>0)&&(xmax<maxY-1))
        {
            for(int i=0;i<xmin;i++)
                cout<<" ";
            for(int i=xmin;i<xmax;i++)
                cout<<"X";
        }
        cout<<"\n";//znak nowej lini
    }
    return 0;
}
