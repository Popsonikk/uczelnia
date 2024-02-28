#include <iostream>
#include <string>
struct Vege{
    std::string name;
    float dirt;
    int nasad;
    short month;
};
void sortVegesByDirt(Vege* veges,int a,int b)
{
    Vege vege;
    int j;
    for(int i=a;i<b;i++)
    {
        vege=veges[i];
        j=i-1;
        while(j>=a-1&&veges[j].dirt<vege.dirt)
        {
            veges[j+1]=veges[j];
            j--;
        }
        veges[j+1]=vege;
    }
}
void sortVegesByNasad(Vege* veges,int a,int b)
{
    Vege vege;
    int j;
    for(int i=a;i<b;i++)
    {
        vege=veges[i];
        j=i-1;
        while(j>=a-1&&veges[j].nasad<vege.nasad)
        {
            veges[j+1]=veges[j];
            j--;
        }
        veges[j+1]=vege;
    }
}
void sortVegesByMonth(Vege* veges,int a,int b)
{
    Vege vege;
    int j;
    for(int i=a;i<b;i++)
    {
        vege=veges[i];
        j=i-1;
        while(j>=a-1&&veges[j].month<vege.month)
        {
            veges[j+1]=veges[j];
            j--;
        }

        veges[j+1]=vege;
    }
}

void sortVeges(Vege* veges,short order[],int n)
{
    int a=1,b=1,c=1,d=1;
    if(order[0]==1)
    {
        sortVegesByDirt(veges,1,n);
        for(int i=1;i<n;i++)
        {
            if(veges[i-1].dirt==veges[i].dirt)
                {a=i;b=i;}
            while(veges[i-1].dirt==veges[i].dirt&&i<n)
            {
                b++;
                i++;
            }
            if(order[1]==2)
            {
                sortVegesByNasad(veges,a,b);
                for(int k=a;k<b;k++)
                {
                    if(veges[k-1].nasad==veges[k].nasad)
                        {c=k; d=k;}
                    while(veges[k-1].nasad==veges[k].nasad&&k<b)
                    {
                        d++;
                        k++;
                    }
                    if(c!=d)
                        sortVegesByMonth(veges,c,d);
                    c=1;d=1;
                }
            }
            if(order[1]==3)
            {
                sortVegesByMonth(veges,a,b);
                for(int k=a;k<b;k++)
                {
                    if(veges[k-1].month==veges[k].month)
                        {c=k; d=k;}
                    while(veges[k-1].month==veges[k].month&&k<b)
                    {
                        d++;
                        k++;
                    }
                    if(c!=d)
                        sortVegesByNasad(veges,c,d);
                    c=1;d=1;
                }
            }
            a=1;b=1;
        }
    }
    if(order[0]==2)
    {
        sortVegesByNasad(veges,1,n);
        for(int i=1;i<n;i++)
        {
            if(veges[i-1].nasad==veges[i].nasad)
                {a=i;b=i;}
            while(veges[i-1].nasad==veges[i].nasad&&i<n)
            {
                b++;
                i++;
            }
            if(order[1]==1)
            {
                sortVegesByDirt(veges,a,b);
                for(int k=a;k<b;k++)
                {
                    if(veges[k-1].dirt==veges[k].dirt)
                        {c=k; d=k;}
                    while(veges[k-1].dirt==veges[k].dirt&&k<b)
                    {
                        d++;
                        k++;
                    }
                    if(c!=d)
                        sortVegesByMonth(veges,c,d);
                    c=1;d=1;
                }
            }
            if(order[1]==3)
            {
                sortVegesByMonth(veges,a,b);
                for(int k=a;k<b;k++)
                {
                    if(veges[k-1].month==veges[k].month)
                        {c=k; d=k;}
                    while(veges[k-1].month==veges[k].month&&k<b)
                    {
                        d++;
                        k++;
                    }
                    if(c!=d)
                        sortVegesByDirt(veges,c,d);
                    c=1;d=1;
                }
            }
            a=1;b=1;
        }
    }
    if(order[0]==3)
    {
        sortVegesByMonth(veges,1,n);
        for(int i=1;i<n;i++)
        {
            if(veges[i-1].month==veges[i].month)
               {a=i;b=i;}
            while(veges[i-1].month==veges[i].month&&i<n)
            {
                b++;
                i++;
            }
            if(order[1]==2)
            {
                sortVegesByNasad(veges,a,b);
                for(int k=a;k<b;k++)
                {
                    if(veges[k-1].nasad==veges[k].nasad)
                        {c=k; d=k;}
                    while(veges[k-1].nasad==veges[k].nasad&&k<b)
                    {
                        d++;
                        k++;
                    }
                    if(c!=d)
                        sortVegesByDirt(veges,c,d);
                    c=1;d=1;
                }
            }
            if(order[1]==1)
            {
                sortVegesByDirt(veges,a,b);
                for(int k=a;k<b;k++)
                {
                    if(veges[k-1].dirt==veges[k].dirt)
                        {c=k; d=k;}

                    while(veges[k-1].dirt==veges[k].dirt)
                    {
                        d++;
                        k++;
                    }
                    sortVegesByNasad(veges,c,d);
                    c=1;d=1;
                }
            }
            a=1;b=1;
        }
    }
}
int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    int n;
    short order[3];
    std::cin>>n;
    std::cin>>order[0]>>order[1]>>order[2];
    Vege *vegesUp ,*vegesDown;
    vegesUp= new Vege[n];
    vegesDown= new Vege[n];
    for(int i=0;i<n;i++)
      std::cin>>vegesDown[i].name>>vegesDown[i].dirt>>vegesDown[i].nasad>>vegesDown[i].month;
    for(int i=0;i<n;i++)
       std::cin>>vegesUp[i].name>>vegesUp[i].dirt>>vegesUp[i].nasad>>vegesUp[i].month;
    sortVeges(vegesDown,order,n);
    sortVeges(vegesUp,order,n);
    for(int i=0;i<n;i++)
        std::cout<<vegesDown[i].name<<'-'<<vegesUp[i].name<<' ';
    delete [] vegesUp;
    delete [] vegesDown;
}
