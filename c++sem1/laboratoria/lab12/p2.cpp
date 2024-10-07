#include <iostream>

using namespace std;

int najdluzsza_sciezka_dereferencji(void ** tab, int n, void **& poczatek_sciezki)
{
    int najdluzsza = 0;
    for(int i = 0; i < n; i++)
    {
        int dlugoscAktualnej = 0;
        void * aktualny = tab[i];
        while(aktualny)
        {
            dlugoscAktualnej++;
            aktualny = *(void **)aktualny;
            if(dlugoscAktualnej > n) {
                dlugoscAktualnej = 0;
                break;
            }
        }
        if(dlugoscAktualnej > najdluzsza)
        {
            najdluzsza = dlugoscAktualnej;
            poczatek_sciezki = &tab[i];
        }
    }
    return najdluzsza;
}

int main()
{

    void *arr[10];
    arr[0] = &arr[5];
    arr[5] = &arr[4];
    arr[4] = nullptr;
    arr[1] = &arr[9];
    arr[9] = &arr[3];
    arr[3] = &arr[1];
    arr[2] = nullptr;
    arr[6] = &arr[3];
    arr[7] = &arr[5];
    arr[8] = &arr[0];

    void ** wsk;
    int wynik = najdluzsza_sciezka_dereferencji(arr, 10, wsk);
    cout<<wynik<<endl;
    cout<<(wsk - arr);
    return 0;
}
