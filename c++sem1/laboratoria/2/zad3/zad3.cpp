#include <iostream>

using namespace std;

int main()
{
   int rok;
   cout<<"rok";
   cin>>rok;
   bool czy_przestepny;
   if(rok%4==0)
   {
       if(rok%100==0)
       {
           if(rok%400==0)
               czy_przestepny=true;
           else
             czy_przestepny=false;
       }
       else
          czy_przestepny=true;
   }
   else
       czy_przestepny=false;
   if(czy_przestepny)
       cout<<"leap year";
    else
       cout<<"common year";
   return 0;
}
