#include <iostream>
#include <cstdlib>
using namespace std; 
int compare( const void * a , const void * b)
{​​​​
    int ** pa = (int **) a;
    int ** pb = (int **) b;
    cout << (*pa)[0] << (*pa)[1];
    return 0;

}​​​​ 
int main()

{​​​​
    float tab[][2] = {​​​​4, 7 , 9 , 6 , 3 , 4, 2 , 3 ,5 , 9}​​​​;
    qsort(tab,5,sizeof(float)*2,compare);
    return 0;
}​​​​

