#include <iostream>
#include <string>
#include <cstdlib>
#include <cstdio>
#include <iomanip>
#include <cmath>
using namespace std;
int f(int *arr,int k)
{
    if(k==0) return *arr;
    else if(k>0&&k<4) return f(arr,k-1)+arr[k-1];
    else if(k>4) return sqrt(f(arr,k-1))+arr[k-1];
}
int main()
{
    char przedzial[5];
    cin>>przedzial;
    int b=(int)przedzial[1]-'0';
    int e=(int)przedzial[3]-'0';
    int N;
    cin>>N;
    int *A=new int[N];
    for(int i=0;i<N;i++)
    {
        A[i]=rand()%e+b;
    }
    for(int i=0;i<N;i++)
    {
        cout<<A[i]<<' ';
    }
    int k=(b+e)%N;
    cout<<"wynik"<<setprecision(3)<<f(A,k);
    delete[]A;

}
