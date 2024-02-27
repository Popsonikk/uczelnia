#include <iostream>
#include <queue>

const int simpleArraySize = 32;
const int heap = 32;
struct TeacherCard
{
    int code;
    int score;
};
struct ArraysIndexes
{
    int begin;
    int end;
};
void przesianie(TeacherCard * inputArr, int index, int n) // ustawienie elementu na odpowiedniej pozycji
{
    for(int i=index,a1=0,a2=0;(2*i+1)<n;) //warunek dopóki dziecko mieści się w tablicy
    {
        a1=inputArr[2*i+1].score;
        if((2*i+2)<n) //sprawdzenie czy rodzic posiada prawe dziecko
            a2=inputArr[2*i+2].score;
        else
            a2=0;

        if(a1>=a2&&a1>inputArr[i].score) //zamiana z większym dzieckiem
        {
            std::swap(inputArr[i],inputArr[2*i+1]);
            i=2*i+1;
        }
        else if( a2>=a1&&a2>inputArr[i].score )
        {
            std::swap(inputArr[i],inputArr[2*i+2]);
            i=2*i+2;
        }
        else
            break;

    }
}
void heapSort( TeacherCard * input, int n)
{
   // std::cout<<'\n'<<"hello"<<'\n';
    for(int i=n/2-1;i>=0;i--) //tworzymy drzewo, pomijamy liście
        przesianie(input,i,n);
    for(int i=0,arrSize=n-1;i<n-1;i++,arrSize--) //zamieniamy korzeń z elementem ostatnim, zmiejszamy rozmiar o 1
    {
        std::swap(input[0],input[arrSize]);
        przesianie(input,0,arrSize);  //naprawiamy strukturę drzewa
    }
    for(int i=0;i<n;i++)
        std::cout<<input[i].score<<' ';
  //  std::cout<<std::endl;

}
void countingSort( TeacherCard* input, int n, int arrSize,int a)
{
    int* pom= new int [arrSize]; //lista kluczy
    for(int i=0;i<arrSize;i++)
        pom[i]=0;
    for(int i=0;i<n;i++)
        pom[(input[i].score)-a]++; //minimalny wynik nie musi być 0 dlatego odejmujemy go aby zestandaryzować do 0
    for(int i=0;i<arrSize;i++)
    {
        for(int j=0;j<pom[i];j++)
            std::cout<<i+a<<' ';
    }
    delete [] pom;
}

void introSort(TeacherCard* input, int n) { //quicksort + heapsort
    if (n <= 1) return;

    TeacherCard pivot = input[0]; //wybieramy element
    TeacherCard* ltPivots = new TeacherCard[n];
    TeacherCard* gtPivots = new TeacherCard[n];
    int l = 0, r = 0, pivoltCount=1;

    for (int i = 1; i < n; i++) //przepisujemy
    {
        if (input[i].score < pivot.score)
            ltPivots[l++] = input[i];
        else if (input[i].score == pivot.score)
        {
            ltPivots[l++] = input[i];
            pivoltCount++;
        }
        else
            gtPivots[r++] = input[i];
    }
    ltPivots[l++] = input[0];


    //std::cout<<"l "<<l<<" r "<<r<<'\n';
    if(r==0&&pivoltCount==l)//warunek jeżeli lewa tablica ma wartości tylko pivolt
    {
        for(int i=0;i<l;i++)
           std::cout<<ltPivots[i].score<<' ';
       // std::cout<<std::endl;
        delete[] ltPivots;
        delete[] gtPivots;
        return;
    }
    else if (l>heap)
        introSort(ltPivots, l);
    else
        heapSort(ltPivots, l);



   if (r>heap)
       introSort(gtPivots, r);
   else
       heapSort(gtPivots, r);


    delete[] ltPivots;
    delete[] gtPivots;
}

void insertionSort(TeacherCard * input, int startIndex, int endIndex) { //wstawianie
    for (int i = startIndex + 1; i <= endIndex; i++) { //przesuwamy najmniejszy element na początek tablicy
        TeacherCard temp = input[i];
        int j = i - 1;
        while (j >= startIndex && input[j].score > temp.score) {
            input[j + 1] = input[j];
            j--;
        }
        input[j + 1] = temp;
    }
}


void mergeSort(TeacherCard * input, int l, int m, int r) //indeksy to start lewy, koniec lewy oraz koniec prawy
{
    int leftSize= m-l+1;
    int rightSize= r-m; //obliczmy rozmiary
    TeacherCard * leftSide= new TeacherCard[leftSize];
    TeacherCard * rightSide= new TeacherCard[rightSize];
    for(int i=l,j=0;i<=m;i++,j++)
        leftSide[j]=input[i];
    for(int i=m+1,j=0;i<=r;i++,j++) //przepisujemy do tablic pomocniczych
        rightSide[j]=input[i];
    int leftIter=0, rightIter=0;

    for(int i=l;leftIter<leftSize&&rightIter<rightSize;i++) //przepisujemy mniejszy element to tablicy wynikowej
    {

        if(leftSide[leftIter].score<=rightSide[rightIter].score)
        {
            input[i]=leftSide[leftIter];
            leftIter++;
        }
        else
        {
            input[i]=rightSide[rightIter];
            rightIter++;
        }
    }
    while(leftIter<leftSize) //przepisujemy pozostałe elementy gdzy jedna z tablic ulegnie wyczerpaniu
    {
        input[l+rightSize+leftIter]=leftSide[leftIter];
        leftIter++;
    }
    while(rightIter<rightSize)
    {
        input[l+rightIter+leftSize]=rightSide[rightIter];
        rightIter++;
    }

    delete[] leftSide;
    delete [] rightSide;
}


void timsort(TeacherCard* input,int n) //wstawianie + merge
{
    std::queue<ArraysIndexes> indexes;
    int reszta= n%simpleArraySize; //sprawdzamy czy tablica do posortowania jest wielokrotnoscią naszego podstawowego przypadku
    int i=0; //zmienna iteracyjna
    while ( i < n-reszta )
    {
        int j=i + simpleArraySize - 1;
        insertionSort(input, i, j);
        indexes.push({i,j});
        i=j+1;

    }
    if(i!=n)
    {
        insertionSort(input, i, n- 1);
        indexes.push({i,n-1});
    }

    ArraysIndexes a1,a2;
    while(indexes.size()>1)
    {

        a1=indexes.front();
       // std::cout<<"a1 "<<a1.begin<<" "<<a1.end;
        indexes.pop();
        a2=indexes.front();
        //std::cout<<" a2 "<<a2.begin<<" "<<a2.end;
        indexes.pop(); //popieramy indeksy pierwszych dwóch tablic w kolejce
        mergeSort(input,a1.begin,a1.end,a2.end);
        if(indexes.front().end==n-1) //sprawdzamy czy przeszliśmy całą tablice, czy piewsza tablica z góry ma koncowy index w rozmiarze
        {
            //std::cout<<"hello"<<'\n';
            a2=indexes.front();
           // std::cout<<" a2e "<<indexes.front().begin<<" "<<indexes.front().end;
            indexes.pop();
            mergeSort(input,a1.begin,a2.begin-1,a2.end);
        }

        indexes.push({a1.begin,a2.end});//dodajemy połączoną tablicę z powrotem do kolejki
       // std::cout<<" w "<<indexes.back().begin<<' '<<indexes.back().end<<'\n';

    }

   for(int i=0;i<n;i++)
        std::cout<<input[i].code<<' ';


}
int main()
{
    std::ios_base::sync_with_stdio(false);
    int n,minScore,maxScore, flag;
    std::cin>>n>>minScore>>maxScore>>flag;
    TeacherCard * cards= new TeacherCard[n];
    for(int i=0;i<n;i++)
        std::cin>>cards[i].code>>cards[i].score;
    if(flag ==1)
    {
        if (n>1000)
           countingSort(cards,n,maxScore-minScore+1,minScore);
        else
            introSort(cards,n);
    }
    else
        timsort(cards,n);
    delete [] cards;

}
