#include <iostream>
#include <cstring>
using namespace std;
char* replace(char* mod, const char rem[],const char add[])
{

    int remlen=strlen(rem);// dlugosc napisu
    int addlen=strlen(add);
    char* pos;
    if(addlen>remlen)
    {
        int count=0;
        pos=mod-remlen;
        while( pos=strstr(pos+remlen,rem))
            count++;
        char* tmp=new char[strlen(mod)+count*(remlen-addlen)+2],        strcpy(tmp;mod);
        delete[] mod;
        mod=tmp;
    }
    pos=mod-addlen;
    while( pos=strstr(pos,rem)) //wyszukanie napisu
    {
        memmove(pos+addlen,pos+remlen,strlen(pos+remlen)+1);//przesuniecie panieci
        memcpy(pos,add,addlen);//kopia
    }
    return mod;
}
int main()
{
    char* str=new char[100];
    strcpy(str,"ala ma kota ma kota ala jest kota");
    //char str[100]="ala ma kota ma kota ala jest kota";
    str=replace(str,"kota","kotakota");
    cout<<str<<endl;
    delete[] str;
}
