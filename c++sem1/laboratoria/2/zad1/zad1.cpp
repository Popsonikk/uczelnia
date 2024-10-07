#include <iostream>

using namespace std;

int main()
{
    float a,b,c,d;

    cout << "a,b,c,d" << endl;
    cin>>a>>b>>c>>d;
    /*if((c<=b)&&(a<=d))
    {
        printf("intersection");
    }
    else
    {
        printf("no intersection");
    }*/

    if((c>b)||(a>d))
    {
        cout<<"NO "<<"intersection";
    }
   if((c>=b)&&(a<=d))
    {
        float begin=a<c?c:a;
        float end=b<d?b:a;
    }


}
