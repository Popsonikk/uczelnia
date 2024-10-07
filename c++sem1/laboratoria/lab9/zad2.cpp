#include <iostream>
#include <cstring>

using namespace std;

int counter(const char * x, char* (*f2)(const char *, const char *), const char * key) {
    char * pch;
    int cnt = 0;
    pch = f2(x, key);
    while(pch) {
        cnt++;
        pch = f2(pch + 1,key);
    }
    return cnt;
}

char * f1(char ** napisy, int rows, char* (*f2)(const char *, const char *), const char * key) {
    int maxCount = 0;
    char * ret;

    for(int i = 0; i < rows; i++) {
        int cur = counter(napisy[i], f2, key);
        if(cur > maxCount) {
            maxCount = cur;
            ret = napisy[i];
        }
    }
    return ret;
}

int main(int argc, char * argv[])
{
    cout<<f1(argv+1, argc - 1, strstr, "as");
    return 0;
}
