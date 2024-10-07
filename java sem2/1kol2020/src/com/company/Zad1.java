package com.company;


import java.util.StringTokenizer;

public class Zad1
{
    final private String text;
    public Zad1(String text) {
        this.text = text;
    }
    private String charToString (char a)
    {return Character.toString(a); }
    public String method1 (char n1 ,char n2) throws  NullPointerException{
        String line;
        StringBuilder x = new StringBuilder();
        StringTokenizer st=new StringTokenizer(text);
        while (st.hasMoreTokens())
        {
            line = st.nextToken().toLowerCase();
            //System.out.println(line);
            if(line.startsWith(charToString(n1).toLowerCase())&&line.endsWith(charToString(n2).toLowerCase()))
            {
                //int k=line.length()-3;
                x.append(charToString(n1));
                x.append("*".repeat(Math.max(0, line.length() - 3)));
                x.append(n2);
                x.append(" ");

            }
            else
            {
                x.append(line);
                x.append(" ");
            }

        }
        return  x.toString();
    }
    public String method2()
    {
        String line;
        StringBuilder x = new StringBuilder();
        StringTokenizer st=new StringTokenizer(text);
        char c ;
        while (st.hasMoreTokens())
        {
            line = st.nextToken().toLowerCase();
            for(int i=0;i<line.length();i++)
            {
                c=line.charAt(i);
                if(i==0)
                {
                    if(c>='a'&&c<='z')
                    {
                        c-=32;
                    }
                }
                if(i==line.length()-1)
                {
                    if(c>='a'&&c<='z')
                    {
                        c-=32;
                    }
                }
                x.append(c);
            }
            x.append(" ");
        }
        return x.toString();
    }
}
