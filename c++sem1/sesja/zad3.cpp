#include <iostream>
using namespace std;
void f(int *arr, int **parr,int wie,int n)
{
    int *sum=new int[wie];
    int i=0,j=-1;
    while(i<wie)
    {
        ++j;
        if(arr+j==(parr+i)+0)
        {
            while(arr+j!=(parr+i)+1)
            {
                *(sum+i)+=*(arr+j);
                j++;
            }
            i++;
            j=-1;
        }
    }
    for(int a=0;a<wie;a++)
    {
        for(int b=0;b<wie;b++)
        {
            if(sum[a]<sum[b])
            {
                swap(sum[a],sum[b]);
                swap(parr[a][0],parr[b][0]);
                swap(parr[a][1],parr[b][1]);
            }
        }
    }
    while(i<wie)
    {
        ++j;
        if(arr+j==(parr+i)+0)
        {
            while(arr+j!=(parr+i)+1)
            {
                cout<<arr[j];
            }
            i++;
            j=-1;
            cout<<endl;
        }
    }
    delete[]sum;

}
int main()
{
    int n;
    cin>>n;
    int *arr=new int[n];
    for(int i=0;i<n;i++)
    {
        *(arr+i)=rand()%20;
    }
    int wie=3;
    int **parr=new int*[wie];
    for(int i=0;i<wie;i++)
    {
        parr[i]=new int[2];
    }
    *(*(parr+0)+0)=*(arr+0);
    *(*(parr+0)+1)=*(arr+6);
    *(*(parr+1)+0)=*(arr+4);
    *(*(parr+1)+1)=*(arr+8);
    *(*(parr+2)+0)=*(arr+8);
    *(*(parr+2)+1)=*(arr+10);

    delete[]arr;
     for(int i=0;i<wie;i++)
    {
        delete[]parr[i];
    }
    delete[]parr;
}
