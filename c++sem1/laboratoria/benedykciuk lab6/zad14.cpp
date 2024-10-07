#include <iostream>
int search(int arr[],int n,bool w)

{
    int sek=0;

    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            if(arr[i]==arr[j])
            {
                sek=arr[i];
                w=true;
                break;
            }
        }
        if(w)
            break;
    }
    return w?sek:0;
}

int main()
{
    int arr[]={3,1,13,5,7,2,4,5,2,1,2,4};
    std::cout<<"powtarzajacy sie element "<<search(arr,sizeof(arr)/sizeof(arr[0]),0);


}
