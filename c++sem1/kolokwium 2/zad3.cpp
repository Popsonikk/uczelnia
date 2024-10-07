#include <iostream>
#include <cstdlib>
using namespace std;
void fill(float **arr,int n,int m)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
           // *(*(arr+i)+j)=rand()/(RAND_MAX);
           *(*(arr+i)+j)=rand()%20*0.5;
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
void f(float **arr,int n,int m,float **result)
{
    int k=0;
    for(int i=0;i<n;i++)
    {
        k=0;
        for(int j=0;j<m;j++)
        {
             if(*(*(arr+i)+j)-*(*(arr+i)+j)==0)
             {
                *(*(result+i)+k)=*(*(arr+i)+j);
                k++;
             }
             else
             {
                 *(*(result+i)+k)=(int)*(*(arr+i)+j);
                 *(*(result+i)+k+1)=*(*(arr+i)+j)-(int)*(*(arr+i)+j);
                 k+=2;
             }
        }
    }

}
int main()
{
    int n,m;
    cout<<"podaj n m ";
    cin>>n>>m;
    float **arr2d=new float*[n];
    for(int i=0;i<n;i++)
        *(arr2d+i)=new float[m];
    float **arr2d_2=new float*[n];
    for(int i=0;i<n;i++)
        *(arr2d_2+i)=new float[2*m];
    fill(arr2d,n,m);
    show(arr2d,n,m);
    f(arr2d,n,m,arr2d_2);
    show(arr2d_2,n,2*m);
    for(int i=0;i<n;i++)
        delete[]arr2d[i];
    delete[]arr2d;
    for(int i=0;i<n;i++)
        delete[]arr2d_2[i];
    delete[]arr2d_2;


}
