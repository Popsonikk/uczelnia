#include <iostream>
int main()
{
    int arr[15],a;
    for(int i=0;i<15;i++)
        arr[i]=i*i;
    for(int i=0;i<5;i++)
    {
        printf("podaj indeks tablicy ");
        scanf("%d",&a);
        if(a<0||a>15)
            printf("indeks zpoza tablicy \n");
        else
            printf("wartosc indeksy %d \n",arr[a]);
    }
}
