#include <iostream>
int rek(int n)
{
    if(n==0||n==1) return 1;
    else if (n%2==0) return rek(n-1)+n;
     else if (n%2==1) return rek(n-1)*n;
}

int main()
{
    int n;
    printf("podaj n ");
    scanf("%d",&n);
    std::cout<<"wynik "<<rek(n);


}
