#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
void f(float arr[][2],int n,int m,float result[][2])
{
    float len[3];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            result[i][0]=arr[i][0]*cos(arr[i][1]);
            result[i][1]=arr[i][0]*sin(arr[i][1]);
            len[i]=sqrt( result[i][0]* result[i][0]+ result[i][1]* result[i][1]);
        }
    }
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n-1;j++)
        {
            if(len[j]<len[j+1])
            {
                swap(result[j][0],result[j+1][0]);
                swap(result[j][1],result[j+1][1]);
                swap(len[j],len[j+1]);

            }
        }
    }
     for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            cout<<result[i][j]<<' ';
        }
        cout<<endl;
    }


}
int main()
{
    float arr[3][2]={1.2, 6.1, 1.2, 1.1 ,5.4 ,3.1};
    float result [3][2];
    f(arr,3,2,result);
}
