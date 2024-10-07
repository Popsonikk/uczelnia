#include <iostream>
void f(int *arr,int n,int *result,int k)
{
    int naj=0,lnaj=0,i=0;
    while(i<k)
    {
        naj=0;
        if(i==0)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[j]>naj)
                    naj=arr[j];
            }
        }
        else
            for(int j=0;j<n;j++)
            {
                if(arr[j]>naj&&arr[j]<lnaj)
                    naj=arr[j];
            }
        result[i]=naj;
        lnaj=naj;
        std::cout<<result[i]<<' ';
        i++;
    }

}
int main()
{
    int arr[10]={7,3,1,10,5,8,4,22,2,13};

    int k;
    printf("k");
    scanf("%d",&k);
    int *result=new int [k];
    f(arr,10,result,k);
    delete[]result;

}
