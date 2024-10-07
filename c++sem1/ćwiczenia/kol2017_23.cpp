#include <iostream>
using namespace std;
void fill(float **arr,int n,int m)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
            *(*(arr+i)+j)=i*n-j*m;
    }
}
void show(float **arr,int n,int m)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
            cout<<*(*(arr+i)+j)<<' ';
        printf("\n");
    }
}
int sum(float **arr,int n,int m)
{
    int sum=0;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            if(i==0||j==0||i==n-1||j==m-1)
                sum+=*(*(arr+i)+j);
        }
    }
    return sum;
}
int main()
{
    int n,m;
    cout<<"podaj n m ";
    cin>>n>>m;
    float **arr=new float*[n];
    for(int i=0;i<n;i++)
        *(arr+i)=new float[m];
    fill(arr,n,m);
    show(arr,n,m);
    cout<<sum(arr,n,m);

    for(int i=0;i<n;i++)
        delete[]arr[i];
    delete[]arr;

}
