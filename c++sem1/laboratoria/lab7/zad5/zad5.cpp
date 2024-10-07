#include <iostream>
#include <cstring>
using namespace std;
void  move_1(void* dst, void* src,int n)
{
    char* cdst=(char*)dst;
    char* csrc=(char*)src;
    if(src>dst)
    {
        for(int i=0;i<n;i++)
        {
            cdst[i]=csrc[i];
        }
    }
    else
    {
        for(int i=n-1;i>=0;i--)
        {
            cdst[i]=csrc[i];
        }
    }

}


int main()
{
    int arr[]{1,2,3,4,5,6,7,8,9};
    move_1(arr+1,arr+2,4*sizeof(int));
    for(int i=0;i<9;i++)
        {
            cout<<arr[i]<<' ';
        }
    return 0;
}
