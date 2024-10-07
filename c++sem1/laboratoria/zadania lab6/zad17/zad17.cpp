#include <iostream>
using namespace std;
void trojkat1(int n)
{
   for(int i=1;i<=n;i++)
   {
       for(int j=1;j<=i;j++)
        {

                    printf("X");

        }
       printf("\n");
   }
}
int main()
{
    int n;
    cout<<"Podaj bok trojkata ";
    cin>>n;
    trojkat1(n);
}
