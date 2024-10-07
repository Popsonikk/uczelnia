#include <iostream>

using namespace std;

void mmv(void *dst, void *src, unsigned int bytes) {
    char *cdst = (char*)dst;
    char *csrc = (char*)src;
    for(unsigned int i=0; i<bytes; i++)
        std::swap(*(cdst+i),*(csrc+i));

}

int main()
{
    int arr[20];
    for(int i=0; i<20; i++) arr[i]=(20-i)*100+i;
    mmv(arr+2, arr+10, 1);
    for(int i=0; i<20; i++)
        cout << arr[i] << " ";
    return 0;
}
