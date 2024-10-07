#include <iostream>
//#include <cstdlib>
using namespace std;
int zad_2_length(char *c)
{
    int size=0;
    for (;c[size]!=' ' && c[size]!='\0';size++);

    return size;

}
char *zad_2_longest_word(char *c)
{   int max=0, sum=0;
    char *result;

    while(c[sum]!='\0')
    {
        int temp=zad_2_length(c+sum);
        if (max<temp)
        {
            max=temp;
            result=c+sum+1;
        }
        sum=sum+temp+1;
    }

    return result-1;
}

int main()
{   char c[]="Ala maaaaaaaaa kotka";
    cout<<c<<endl;
    cout<<zad_2_longest_word(c)<<endl;

    return 0;
}
