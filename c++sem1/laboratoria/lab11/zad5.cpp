#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
struct Point
{
    float x;
    float y;

};


void rotate(Point *arr,int n, float angle)
{
    Point avg={0,0};
    for_each(arr,arr+n,[&avg](Point p){
       avg.x+=p.x;
       avg.y+=p.y;

    });
    avg=Point{avg.x/n,avg.y/n};
    angle*=M_PI/180;
    std::transform(arr,arr+n,arr,[avg,angle](Point p){
        p.x-=avg.x;
        p.y-=avg.y;
        p.x=p.x*cos(angle)-p.y*sin(angle);
        p.y=p.y*sin(angle)+p.y*cos(angle);
        p.x+=avg.x;
        p.y+=avg.y;
        return p;
    });
}
void printPolygon(Point *points, int n){
    int width=512, height=512;

    cout << "<svg height=\"" << height << "\" width=\"" << width <<"\">" << endl;
    cout << "<polygon points =\"";
    for(int i=0;i<n;i++){
        cout << points[i].x<< "," << points[i].y << " ";
    }

    cout << "\"stroke=\"black\" stroke-width=\"2\" stroke-linecap=\"butt\" fill=\"none\"/>" << endl;

    cout << "</svg>" << endl;
}


int main()
{
    Point points[5]={{300,200},{100,500},{200,400},{300,400},{300,200}};
    printPolygon(points,5);
    rotate(points,5,5);
    printPolygon(points,5);
    return 0;
}
