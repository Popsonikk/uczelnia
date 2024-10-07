#include <iostream>
using namespace std;
double abs_diff(const double* a,const double* b)
{
   double diff = *a - *b;
   return diff>0? diff:-1*diff;
}
int main()
{
    double a,b;
    cout<<"podaj 2 liczby ";
    cin>>a>>b;
    cout<<"roznica "<<abs_diff(&a,&b);
    return 0;
}
