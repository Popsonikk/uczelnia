#include <stdio.h>

typedef struct{
    unsigned int x;
    unsigned int y;
}Point;
//typedef struct Point Point;
int main()
{
    Point pts={1,2};
    Point arr[5] = {0x12345678,3,31,63,5,65,1,8,333,0};
    FILE *file;
    file = fopen("bitowe.txt","wb");
    fwrite(&pts,sizeof(Point),1,file);
    fwrite(arr,sizeof( Point),5,file);
    fclose(file);
    return 0;
}
