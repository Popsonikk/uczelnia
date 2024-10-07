#include <iostream>
#include <cstring>
using namespace std;
void  printarrsumarry(float arr[],int n)
{
    bool found;
    float* dict=new float[n];
    int* cunt=new int[n]();
    //memset(cunt,0,n*sizeof(int)) //wype³nienie tablicy zerami (wskaznik tablicy, liczba,liczba bajtw)
    int index=0;
    for(int i=0;i<n;i++)
    {
        found = false;
        for(int j=0;j<index;j++)
        {
            if(dict[j]==arr[i])
            {
                cunt[j]++;
                found=true;
                break;
            }
        }
        if(found==false)
        {
            dict[index]=arr[i];
            cunt[index]+=1;
            index++;
        }
    }
    for(int i=0;i<index;i++)
        for(int j=index-1;j>=i;j--)
            if(cunt[i]>cunt[j])
                {
                    int tmp=cunt[j];
                    cunt[j]=cunt[i];
                    cunt[i]=tmp;
                    float ftmp=dict[j];
                    dict[j]=dict[i];
                    dict[i]=ftmp;
                }
    for(int i=0;i<index;i++)
    {
        cout<<dict[i]<<' '<<cunt[i]<<endl;
    }
    delete[]dict;
    delete[]cunt;
}
int main()
{
    float arr[]={1,2,3,3,4,3,2,5,6,7,2,1};
    printarrsumarry(arr,sizeof(arr)/sizeof(float));
    return 0;
}
