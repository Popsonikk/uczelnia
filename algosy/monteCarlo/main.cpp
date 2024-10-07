#include <iostream>
#include <string>
#include <stdlib.h>
#include <vector>
#include <iomanip>
using namespace std;
int Grazyna(int HH, int mm){
	if(HH >= 8 && HH < 15) return 0;
	else if(HH >= 15 && HH < 22) return 1;
	return 2;
}

int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int m1,m2,h1,h2,room;
    vector<float> tab;
    tab.resize(6);
    scanf("%d:%d %d:%d %d",&h1,&m1,&h2,&m2,&room);

    m1+=60*h1;
    m2+=60*h2;
    int m=m2-m1;
    for(int i=0;i<1000000;i++)
    {
        int j=rand()%m;
        int x=Grazyna((j+m1)/60,(j+m1)%60);
        tab[x]++;
    }
    cout<<setprecision(2)<<fixed<<tab[room]/1000000;




}
