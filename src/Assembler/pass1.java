
package Assembler;
import java.io.*;
import java.util.Scanner;

public class pass1 {
    
    static String line="",word,mot[];
    static int mots[],n=0,i=0,lc=0,k=0,len=0,lc1,l1;
    public static void main(String[] args) 
    {
        Scanner s;
        try
        {
            FileReader f1=new FileReader("mot.txt");
            FileReader f2=new FileReader("mot.txt");
            FileReader f3=new FileReader("srca.txt");
            PrintWriter p1=new PrintWriter("st.txt");
            PrintWriter p2=new PrintWriter("ifa.txt");
            BufferedReader b1=new BufferedReader(f1);
            BufferedReader b2=new BufferedReader(f2);
            BufferedReader b3=new BufferedReader(f3);
            
            while( (line=b1.readLine())!=null )
                n++;
            mot=new String[n];
            mots=new int[n];
            
            while( (line=b2.readLine())!=null )
            {
                s=new Scanner(line);
                while(s.hasNext())
                {
                    mot[i]=s.next();
                    mots[i]=s.nextInt();
                    i++;
                }
            }
            
            p1.println("Symbol\tValue\tSize");
            p2.println("LC\topcode\toperand");
            while( (line=b3.readLine())!=null )
            {
                s=new Scanner(line);
                p2.println(lc+"\t"+line);
                if( (line.toLowerCase().contains("start")) || (line.toLowerCase().contains("equ")) )
                    l1=1;
                else
                    l1=4;
                while(s.hasNext())
                {
                    word=s.next();
                    len=0;
                    if( (word.toLowerCase().contains("dc")) || (word.toLowerCase().contains("ds")) )
                    {
                        if(lc%4==0)
                            len=4;
                        else
                            len=4+(4-(lc%4));
                            break;
                    }
                    else if(containsCode())
                    {
                        len=mots[k];
                        break;
                    }
                    else if( (word.toLowerCase().contains("start")) || (word.toLowerCase().contains("equ")) || (word.toLowerCase().contains("end")) || (word.toLowerCase().contains("using")) )
                            break;
                    else
                    {
                        if(line.toLowerCase().contains("equ"))
                        {
                            String temp=s.next();
                            lc1=s.nextInt();
                        }
                        else
                            lc1=lc;
                        p1.println(word+"\t"+lc1+"\t"+l1);
                    }
                }
                lc=lc+len;
            }
            p1.close();
            p2.close();
        }catch(IOException e)
        {
        }
    }
    
    static boolean containsCode() 
    {
        for(int i=0;i<n;i++)
        {
            if(word.contains(mot[i]))
            {
                k=i;
                return true;
            }
        }
        return false;
    }
}
