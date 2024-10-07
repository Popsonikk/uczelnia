#include <iostream>
#include <algorithm>

using namespace std;

bool parzysta(int a)
{
    return a%2==0;
}
bool dodatnia(int a)
{
    return a>0;
}
bool ujemna(int a)
{
    return a<0;
}
void populate(int *arr, int n,bool (**fun_arr)(int),int fn,int **result,int *size )
{

    fill(size,size+fn,0);
    for(int i=0;i<fn;i++)
    {
        size[i]=count_if(arr,arr+n,fun_arr[i]);
        result[i]= new int[size[i]];
        copy_if(arr,arr+n,result[i],fun_arr[i]);
    }

}

int main()
{
    const int n=14;
    const int fn=3;
    int arr[14]={1,2,3,4,5,6,7,-2,-5,-4,2,-8,1,-3};
    bool (*fun_arr[fn])(int)={parzysta, dodatnia, ujemna};
    int **result = new int*[fn];
    int *size = new int[fn];
    populate(arr,n,fun_arr,fn,result,size);
    for(int i=0;i<fn;i++)
    {
        for(int j=0;j<size[i];j++)
        {
            cout<<result[i][j]<<" ";
        }
        cout<<endl;
        delete [] result[i];

    }
    delete []size;
    delete []result;



    return 0;
}
