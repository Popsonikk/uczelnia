#include <iostream>
using namespace std;
void fill(int **arr,int n,int m)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
            *(*(arr+i)+j)=i+j;
    }
}
void show(int **arr,int n,int m)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
            cout<<*(*(arr+i)+j)<<' ';
        printf("\n");
    }
    printf("\n");
}
void swap(int **arr,int **result,int n,int m)
{
    int sum=0;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            if(*(*(arr+i)+j)%2)
                *(*(result+i)+j)=*(*(arr+i)+j)+1;
            else
                *(*(result+i)+j)=*(*(arr+i)+j)*3;
        }
    }
}
int main()
{
    int n,m;
    cout<<"podaj n m ";
    cin>>n>>m;
    int **arr1=new int*[n];
    for(int i=0;i<n;i++)
        *(arr1+i)=new int[m];
    int **arr2=new int*[n];
    for(int i=0;i<n;i++)
        *(arr2+i)=new int[m];
    fill(arr1,n,m);
    show(arr1,n,m);
    swap(arr1,arr2,n,m);
    show(arr2,n,m);

    for(int i=0;i<n;i++)
        delete[]arr1[i];
    delete[]arr1;
    for(int i=0;i<n;i++)
        delete[]arr2[i];
    delete[]arr2;

}
