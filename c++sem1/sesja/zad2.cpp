#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cmath>
#include <iomanip>
using namespace std;
int f(float *arr,unsigned int n,unsigned int x,float *result)
{

    int el=0,j=0;
    while(j<n)
    {
       result[el]=arr[j];
       el++;
       j+=x;
    }
    return el;
}
int main()
{
    unsigned int n,x;
    cin>>n>>x;
    float *arr=new float[n];
    for(int i=0;i<n;i++)
    {
        *(arr+i)=rand()/(float)RAND_MAX*pow(-1,rand()%2+1);
    }
    float *result=new float[n/x+1];
    int el=f(arr,n,x,result);
    cout<<"el "<<el<<endl;
     for(int i=0;i<el;i++)
    {
        cout<<setprecision(2)<<*(result+i)<<' ';
    }
    delete[]arr;
    delete[]result;
}
