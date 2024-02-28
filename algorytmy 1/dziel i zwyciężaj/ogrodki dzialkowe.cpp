#include <iostream>
int wynik=1; //zmienna globalna do zliczania ilosci dzialek(wywolan funkji dziel)
bool czyznaleziono=true;
void sortbyX(int **arr,int start,int koniec) //sortowanie przez wstawianie po osi y
{
     int *pom;
     int j;
     for(int i=start;i<koniec;i++) //start >=1
     {
        pom=arr[i];
        j = i-1;
        while(j>=start-1&&arr[j][0]>pom[0])
        {
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=pom;
     }
}
void sortbyY(int **arr,int start,int koniec) //sortowanie przez wstawianie po osi x
{
     int *pom;
     int j;
     for(int i=start;i<koniec;i++) //start >=1
     {
        pom=arr[i];
        j = i-1;
        while(j>=start-1&&arr[j][1]>pom[1])
        {
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=pom;
     }
}


void dzielZwyczezaj(int **arr,int start,int koniec,bool tryb)
{
    //przerwanie algorytmu
    if(start==koniec||!czyznaleziono)//funckja w ktoryms podproblemie nie znalazla podzialu lub 1 budynek
        return;

    //algorytm

    if(tryb) //poprzeni podzial byl po  x (ograniczenie sortowania)
    {
        int maxX=arr[start-1][0];
        for(int i=start;i<koniec;i++)
        {
            if(arr[i-1][2]>maxX)
                maxX=arr[i-1][2];
            if(maxX<=arr[i][0])
            {
                wynik++;
                dzielZwyczezaj(arr,start,i,true);
                dzielZwyczezaj(arr,i+1,koniec,true);
                return;
            }
        }
        sortbyY(arr,start,koniec);
        int maxY=arr[start-1][1];
        for(int i=start;i<koniec;i++)
        {
            if(arr[i-1][3]>maxY)
                maxY=arr[i-1][3];
            if(maxY<=arr[i][1])
            {
                wynik++;
                dzielZwyczezaj(arr,start,i,false);
                dzielZwyczezaj(arr,i+1,koniec,false);
                return;
            }
        }
    }
    else //poprzeni podzial byl po  y (ograniczenie sortowania)
    {
        int maxY=arr[start-1][1];
        for(int i=start;i<koniec;i++)
        {
            if(arr[i-1][3]>maxY)
                maxY=arr[i-1][3];
            if(maxY<=arr[i][1])
            {
                wynik++;
                dzielZwyczezaj(arr,start,i,false);
                dzielZwyczezaj(arr,i+1,koniec,false);
                return;
            }
        }
        sortbyX(arr,start,koniec);
        int maxX=arr[start-1][0];
        for(int i=start;i<koniec;i++)
        {
            if(arr[i-1][2]>maxX)
                maxX=arr[i-1][2];
            if(maxX<=arr[i][0])
            {
                wynik++;
                dzielZwyczezaj(arr,start,i,true);
                dzielZwyczezaj(arr,i+1,koniec,true);
                return;
            }
        }
    }
    czyznaleziono=false;
    return;
}
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int tests;
    std::cin>>tests;
    for(int i=0;i<tests;i++)
    {
        czyznaleziono=true;
        wynik=1; //zerowanie zmiennej globalnej
        int budynki;
        std::cin>>budynki;
        int **wspolrzendne=new int*[budynki];
        for(int j=0;j<budynki;j++)
        {
            wspolrzendne[j]=new int[4]; //x1,y1,x2,y2
            std::cin>>wspolrzendne[j][0]>>wspolrzendne[j][1]>>wspolrzendne[j][2]>>wspolrzendne[j][3];
        }
        if(budynki ==1)
        {
            std::cout<<"TAK"<<"\n"; // jeden bydynek jest jednoznaczy z 1 dzialka wiec istnieje trywialny podzial do ktorego nie trzeba uzywac algorytmu
            continue;
        }
        sortbyX(wspolrzendne,1,budynki);
        dzielZwyczezaj(wspolrzendne,1,budynki,true);
        //std::cout <<wynik;
        if(czyznaleziono) //dzialek jest co najwyzej tyle ile budynkow
            std::cout<<"TAK"<<"\n"; //podzia³ istnieje jezeli dzialek jest tyle co budynkow
        else
            std::cout<<"NIE"<<"\n";

    }
}
