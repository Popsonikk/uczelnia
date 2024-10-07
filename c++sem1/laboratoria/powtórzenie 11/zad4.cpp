#include <iostream>
#include <cstring>
using namespace std;
char* find_substring(char str[],char str2[])
{

    char *index=nullptr;
    for(int i=0;str[i];i++)
    {
        bool czy=true;
        if(str[i]==str2[0])
        {
            for(int j=1;str[i+j]&&str2[j];j++)
            {

                if(str[i+j]!=str2[j])
                {
                       czy=false;
                       break;
                }
                if(czy)
                {
                    index=str+i;
                }
            }
        }

    }
    return index;
}
int main()
{
    char str[]="ala ma kota";
    char str2[]="kota";
    char *found=find_substring( str, str2);
     if(found) cout << found - str << endl;
      else cout << "not found\n";

}

