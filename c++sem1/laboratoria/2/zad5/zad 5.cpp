#include <iostream>

using namespace std;

int main()
{
    int width=400, height=400;
    int x1,x2,y1,y2,a=1,b=0;
    x1=-width/2;
    x2=width/2;
    y1=a*x1+b;
    y2=a*x2+b;

    cout << "<svg height=\"" << height <<"\" width=\"" << width << "\">" << endl;
    cout << "<line x1=\"" << width/2 << "\" y1=\"" << 0 << "\" x2=\"" << width/2 << "\" y2=\"" << height-1 << "\" style=\"stroke:black\" />"  << endl;
    cout << "<line y1=\"" << height/2 << "\" x1=\"" << 0 << "\" y2=\"" << height/2 << "\" x2=\"" << width-1 << "\" style=\"stroke:black\" />"  << endl;
     cout << "<line x1=\"" << x1+width/2 << "\" y1=\"" << -y1+height/2 << "\" x2=\"" << x2+width/2 << "\" y2=\"" << height-y2 << "\" style=\"stroke:blue\" />"  << endl;
    cout << "</svg>" << endl;

    return 0;
}

//  <line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(255,0,0);stroke-width:2" />
