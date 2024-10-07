#include <iostream>
#include <cmath>
using namespace std;
void len(float arr[][2],int n)
{
    int n1=0,n2=0;
    float h=0,lmax=0;
    for(int i=0;i<n-1;i++)
    {
          for(int j=i+1;j<n;j++)
            {
                h=sqrt(pow(arr[i][0]-arr[j][0],2)+pow(arr[i][1]-arr[j][1],2));
                if(h>lmax)
                {
                    lmax=h;
                    n1=i;
                    n2=j;
                }
            }
    }
    cout<<n1<<' '<<n2;
}
int main()
{
    float arr[3][2]={{2.0,1.0},{0.0,0.0},{10.0,10.0}};
    int n=3;
    len(arr,n);
}
