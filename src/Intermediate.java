
import java.util.Scanner;

public class Intermediate 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the inpue String");
        String s=sc.nextLine();
        char a[]=new char[s.length()];
        a=s.toCharArray();
        int length = a.length;
        do
        {
            for(int i=2;i<length;i++)
            {
                if(a[i]=='/')
                {
                    System.out.println("x="+a[i-1]+a[i]+a[i+1]);
                    a[i-1]='x';
                    for(int j=i+2,k=i;j<a.length;j++,k++)
                        a[k]=a[j];
                    System.out.println("Intermediate code:-");
                    for(int l=0;l<length-2;l++)
                        System.out.print(a[l]);
                    length=length-2;
                    System.out.println();
                }
            }
            
            for(int i=2;i<length;i++)
            {
                if(a[i]=='*')
                {
                    System.out.println("y="+a[i-1]+a[i]+a[i+1]);
                    a[i-1]='y';
                    for(int j=i+2,k=i;j<a.length;j++,k++)
                        a[k]=a[j];
                    System.out.println("Intermediate code:-");
                    for(int l=0;l<length-2;l++)
                        System.out.print(a[l]);
                    length=length-2;
                    System.out.println();
                }
            }
            
            for(int i=2;i<length;i++)
            {
                if(a[i]=='+')
                {
                    System.out.println("z="+a[i-1]+a[i]+a[i+1]);
                    a[i-1]='z';
                    for(int j=i+2,k=i;j<a.length;j++,k++)
                        a[k]=a[j];
                    System.out.println("Intermediate code:-");
                    for(int l=0;l<length-2;l++)
                        System.out.print(a[l]);
                    length=length-2;
                    System.out.println();
                }
            }
            
            for(int i=2;i<length;i++)
            {
                if(a[i]=='-')
                {
                    System.out.println("w="+a[i-1]+a[i]+a[i+1]);
                    a[i-1]='w';
                    for(int j=i+2,k=i;j<a.length;j++,k++)
                        a[k]=a[j];
                    System.out.println("Intermediate code:-");
                    for(int l=0;l<length-2;l++)
                        System.out.print(a[l]);
                    length=length-2;
                    System.out.println();
                }
            }   
        }while(length!=1);
    }
}