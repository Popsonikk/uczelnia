#include <iostream>
#include <string>
#include <cstdio>
using namespace std;
struct Netstat
{
    int type;
    bool state;
    string address;
    void write_netstat(const char *filename ,Netstat arr, int n)
    {
        FILE* in;
        in = fopen(filename ,"ab");
        fwrite(arr,sizeof(Netstat),n,in);
        fclose(in);
    }
    int read_netstat(const char *filename ,Netstat arr, int n)
    {
        int i=0;
        FILE * in;
        in = fopen(filename ,"rb");
        if(fscanf(in,"%s",arr)!=EOF)
        {

        }
        fclose(in);

    }


};
int main()
{
    Netstat arr[3]={{1,0,"www"},{2,1,"www"},{3,8,"www"}};
    for(int i=0;i<3;i++)
    {
        arr[i].write_netstat("cwiczenie.txt",)arr,3);
    }
    Netstat arr2[3];
     for(int i=0;i<3;i++)
    {
        arr[i].read_netstat("cwiczenie.txt",arr2,3);
    }


}
