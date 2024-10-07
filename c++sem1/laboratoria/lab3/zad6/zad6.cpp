#include <iostream>
#include <cmath>
using namespace std;
int main()
{
    int maxY=25,maxX=80;
    float unit=1/(float)maxY*2;
    for(int y=maxY;y>=0;y--)
    {
        for(int x=0;x<maxX;x++)
        {
            float yvalue=(sin(x*unit)+1)/unit;
            if((yvalue>=y) && (yvalue<y+1))
                cout<<"x";
            else
                cout<<" ";
        }
    }
    return 0;
}
