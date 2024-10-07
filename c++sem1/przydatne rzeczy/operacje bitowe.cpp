# include <iostream>
using namespace std;
int main()
{
    unsigned int a=1; //01
    unsigned int b=2; //10
    cout<<(a|b);//11 dodawanie pionowe
    cout<<(a&b) ;//00 mno¿enie pionowe
    cout<<(a^b); //11 przeciwne bity daj¹ 1
}
