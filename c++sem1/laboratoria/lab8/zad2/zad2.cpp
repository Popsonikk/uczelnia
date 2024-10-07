#include <iostream>
#include <cstring>
using namespace std;
void sortStrings(char ** tab, char ** sorted, int n) {
    memcpy(sorted, tab, n*sizeof(char*));
    for(int i=0;i<n-1;i++)
        for(int j=0;j<n-i-1;j++)
            if(strcmp(sorted[j], sorted[j+1]) > 0){
                char * tmp=sorted[j];
                sorted[j]=sorted[j+1];
                sorted[j+1]=tmp;
            }
}
int main()
{
    char y[5][4] = {{"bbb"}, {"aba"}, {"bab"}, {"baa"}, {"abb"}};
    char ** x = new char*[5];
    char ** sorted = new char*[5];
    for(int i = 0; i < 5; i++) {
        x[i] = y[i];
    }
    sortStrings(x, sorted, 5);

    for(int i = 0; i < 5; i++) {
        cout<<sorted[i]<<endl;
    }
    cout<<endl;
    for(int i = 0; i < 5; i++) {
        cout<<x[i]<<endl;
    }
    delete[] x;
    delete[] sorted;
    return 0;
}
