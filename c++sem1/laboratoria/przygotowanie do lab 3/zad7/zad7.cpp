#include <iostream>

using namespace std;

int main()
{

    for(int i=1;i<=10;i++)
    {
        for(int j=1;j<=10;j++)
        {
            if(i*j<10)
                cout<<i*j<<"  ";
            else
                cout<<i*j<<' ';
        }
        cout<<endl;
    }
    cout<<endl;
     for(int i=1;i<=10;i++)
    {
        if(i!=1)
            cout<<' ';
        for(int j=1;j<=10;j++)
        {

            if(j>=i)
               {
                   if(i*j<10)
                        cout<<i*j<<"  ";
                    else
                        cout<<i*j<<' ';
               }
            else
            {


                if(i*j<10)
                    cout<<"  ";
                else
                    cout<<"   ";
            }
        }
        cout<<endl;
    }

    return 0;
}
