#include <iostream>
using namespace std;
void fill1(float **arr,int n,int m)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
            *(*(arr+i)+j)=i+j;
    }
}
void fill2(float **arr,int n,int m)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
            *(*(arr+i)+j)=2*i-j;
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
    printf("\n");
}
float sum(float x1,float y1,float x2,float y2)
{
    return x1*x2+y1*y2;
}
void arr_fun(float **arr1,float **wsk,float **arr2,float *result,float(*fun)(float,float,float,float))
{

    int i=0;
    while(wsk-((arr1+i)+1))
    {
        *(result+i)=fun(arr1[i][0],arr1[i][1],arr2[i][0],arr2[i][1]);
        i++;
    }
}
int main()
{
    int n;
    cout<<"podaj n ";
    cin>>n;
    float **arr1=new float*[n];
    for(int i=0;i<n;i++)
        *(arr1+i)=new float[2];
    float **arr2=new float*[n];
    for(int i=0;i<n;i++)
        *(arr2+i)=new float[2];
    float *result=new float[n];
    fill1(arr1,n,2);
    show(arr1,n,2);
    fill2(arr2,n,2);
    show(arr2,n,2);
    float **wsk=(arr1+n)+1;
    arr_fun(arr1,wsk,arr2,result,sum);
    for(int j=0;j<n;j++)
            cout<<*(result+j)<<' ';
    for(int i=0;i<n;i++)
        delete[]arr1[i];
    delete[]arr1;
    for(int i=0;i<n;i++)
        delete[]arr2[i];
    delete[]arr2;
    delete[] result;

}
