#include <iostream>
#include <queue>
//#include <iomanip> //do testow przy wyswietlaniu
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int t,m,n,l;
    int a=0,b=0;
    std::cin>>t;
    for(int i=0;i<t;i++)
    {
        std::queue<int> Mqueue;
        std::queue<int> Oqueue;
        std::cin>>n>>m;
        char **arr= new char *[n];
        int **Mresult= new int *[n];
        int **Oresult= new int *[n];
        for(int x=0;x<n;x++)
        {
            arr[x]=new char[m];
            Mresult[x]=new int[m];
            Oresult[x]=new int[m];
            for(int y=0;y<m;y++)
            {
                std::cin>>arr[x][y];

                Mresult[x][y]=-1;
                Oresult[x][y]=-1;
                if(arr[x][y]=='M')
                {
                    Mresult[x][y]=0;
                    Mqueue.push(x);
                    Mqueue.push(y);
                }
                if(arr[x][y]=='O')
                {
                    Oresult[x][y]=0;
                    Oqueue.push(x);
                    Oqueue.push(y);
                }
            }
        }
        while(!Mqueue.empty())
        {
            a=Mqueue.front();
            Mqueue.pop();
            b=Mqueue.front();
            Mqueue.pop();
           if(a-1>=0&&(arr[a-1][b]!='#')&&(Mresult[a-1][b]==-1))
            {
                Mresult[a-1][b]=Mresult[a][b]+1;
                Mqueue.push(a-1);
                Mqueue.push(b);

            }
            if(a+1<n&&(arr[a+1][b]!='#')&&(Mresult[a+1][b]==-1))
            {
                Mresult[a+1][b]=Mresult[a][b]+1;
                Mqueue.push(a+1);
                Mqueue.push(b);
            }
            if(b-1>=0&&(arr[a][b-1]!='#')&&(Mresult[a][b-1]==-1))
            {
                Mresult[a][b-1]=Mresult[a][b]+1;
                Mqueue.push(a);
                Mqueue.push(b-1);
            }
            if(b+1<m&&(arr[a][b+1]!='#')&&Mresult[a][b+1]==-1)
            {
                Mresult[a][b+1]=Mresult[a][b]+1;
                Mqueue.push(a);
                Mqueue.push(b+1);
            }
        }
        while(!Oqueue.empty())
        {
            a=Oqueue.front();
            Oqueue.pop();
            b=Oqueue.front();
            Oqueue.pop();
            if(a-1>=0&&(arr[a-1][b]!='#')&&(Oresult[a-1][b]==-1||Oresult[a-1][b]>Oresult[a][b]+1))
            {
                Oresult[a-1][b]=Oresult[a][b]+1;
                Oqueue.push(a-1);
                Oqueue.push(b);
            }
            if(a+1<n&&(arr[a+1][b]!='#')&&(Oresult[a+1][b]==-1||Oresult[a+1][b]>Oresult[a][b]+1))
            {
                Oresult[a+1][b]=Oresult[a][b]+1;
                Oqueue.push(a+1);
                Oqueue.push(b);
            }
            if(b-1>=0&&(arr[a][b-1]!='#')&&(Oresult[a][b-1]==-1||Oresult[a][b-1]>Oresult[a][b]+1))
            {
                Oresult[a][b-1]=Oresult[a][b]+1;
                Oqueue.push(a);
                Oqueue.push(b-1);
            }
            if(b+1<m&&(arr[a][b+1]!='#')&&(Oresult[a][b+1]==-1||Oresult[a][b+1]>Oresult[a][b]+1))
            {
                Oresult[a][b+1]=Oresult[a][b]+1;
                Oqueue.push(a);
                Oqueue.push(b+1);
            }
        }
        /*for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                std::cout<<std::setw(3)<<Mresult[i][j]<<" "; //wyœwietlanie algorytmu bfs dla testów
            std::cout<<"\n";
        }
        std::cout<<"\n";
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                std::cout<<std::setw(3)<<Oresult[i][j]<<" ";
            std::cout<<"\n";
        }*/
        l=n*2+m*2-4;
        if(l==0)
            l=1;
        a=0,b=0;
        int minimal=0;
        bool flag=true;
        for(int j=0;j<l;j++)
        {
            if(l==1 &&Mresult[0][0]!=-1)
            {
                flag=false;
                minimal=Mresult[a][b]+1;
                break;
            }

            if(((Mresult[a][b]<Oresult[a][b])||(Mresult[a][b]>=0&&Oresult[a][b]==-1))&&flag&&Mresult[a][b]!=-1)
            {
                flag=false;
                minimal=Mresult[a][b]+1;
            }
            if(((Mresult[a][b]<Oresult[a][b])||(Mresult[a][b]>=0&&Oresult[a][b]==-1))&&Mresult[a][b]+1<minimal&&Mresult[a][b]!=-1)
                minimal=Mresult[a][b]+1;

            if(a==0&&b<m-1)
                b++;
            else if(b==m-1&&a<n-1)
                a++;
            else if(a==n-1&&b>0)
                b--;
            else if(b==0&&a>0)
                a--;


        }
        if(flag)
            std::cout<<"NIE";
        else
            std::cout<<minimal;
        std::cout<<"\n";
    }
}
