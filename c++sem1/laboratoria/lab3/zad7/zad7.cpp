#include <iostream>
#include <cmath>
#include <thread>
#include <chrono>
using namespace std;
int main()
{
    int maxY=23,maxX=80;
    float unit=1/(float)maxY*2;
    for(int i=0;i<100;i++)
    {
        system("cls");
        for(int y=maxY;y>=0;y--)
        {
            for(int x=0;x<maxX;x++)
            {
                float yvalue=(sin((x+i)*unit)+1)/unit;
                if((yvalue>=y) && (yvalue<y+1))
                    cout<<"x";
                else
                    cout<<" ";
            }
        }
        std::this_thread::sleep_for(chrono::milliseconds(30));
    }
    return 0;
}
