#include <iostream>
#include <cstring>
using namespace std;
void remove_duplicates(int * arr[],int rows, int cols)
{
    for(int i=0;i<rows;i++)
    {
        if(!arr[i]) continue;
        for(int j=i+1;j<rows;j++)
        {
            if(!arr[j]) continue;
            if(memcmp(arr[i],arr[j],cols*sizeof(int))==0)
            {
                delete [] arr[j] ;
                arr[j]=nullptr;
            }
        }
    }
}
void print_arr(int * arr[],int rows,int cols)
{
    for(int i=0;i<rows;i++)
    {
        if(!arr[i]) cout<<"nullptr";
        else for(int j=0;j<cols;j++)
        {
            cout<<arr[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<endl;
}
int main()
{
    int **arr = new int*[4];
    for(int i=0; i<4; i++)
        arr[i] = new int[3];
    int temp[3] = {1,1,1};
    memcpy(arr[0],temp,sizeof(int)*3);
    temp[2] = 2;
    memcpy(arr[1],temp,sizeof(int)*3);
    memcpy(arr[2],temp,sizeof(int)*3);
    temp[2] = 3;
    memcpy(arr[3],temp,sizeof(int)*3);
    remove_duplicates(arr,4,3);
    print_arr(arr,4,3);
    return 0;
}
