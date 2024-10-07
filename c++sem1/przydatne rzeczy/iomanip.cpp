#include <iostream>
#include <iomanip>

using namespace std;

int main() {

    for(int i=0; i<=10; i++) {
        for(int j=0; j<=i; j++)
            cout << setfill(' ') << setw(4)<< i*j; //wyrównanie do prawej 4 bajty na znaki pope³nienie spacj¹
        cout << endl;
    }
    return 0;
}
