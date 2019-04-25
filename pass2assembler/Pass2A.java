//Aim:To implement pass 2 of 2 pass assembler
import java.util.*;
import java.io.*;
class  Pass2A
{
	static String line="",word,mot[];
	static int mots[],n=0,i=0,lc=0,k=0,length=0,l1,lc1,symc;
	static String sym[],symval[],bt[][];
	
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
			PrintWriter p3=new PrintWriter("bt.txt");
			PrintWriter p4=new PrintWriter("op.txt");
			BufferedReader b1=new BufferedReader(f1);
			BufferedReader b2=new BufferedReader(f2);
			BufferedReader b3=new BufferedReader(f3);
			while((line=b1.readLine())!=null)
				n++;
			mot=new String[n];
			mots=new int[n];
			sym=new String[10];
			symval=new String[10];
			bt=new String[15][3];
			
			
			while((line=b2.readLine())!=null)
			{
				s=new Scanner(line);
				while(s.hasNext())
				{
						mot[i]=s.next();
						mots[i]=s.nextInt();
						i++;
				}
			}
			for(i=0;i<15;i++)
			{
				bt[i][0]=""+(i+1);
				bt[i][1]="N";
			}
			p1.println("SYMBOL\tVALUE\tSIZE");
			p2.println("LC\tOPCODE\tOPERAND");
			p3.println("REG\tAVAILABILITY\tCONTENT");
			while((line=b3.readLine())!=null)
			{
				s=new Scanner(line);
				p2.println(lc+"\t"+line);
				if((line.contains("START"))||(line.contains("EQU")))
					l1=1;
				else
					l1=4;
				while(s.hasNext())
				{
					word=s.next();
					length=0;
					if((word.contains("DC"))||(word.contains("DS")))
					{
						if((lc%4)==0)
							length=4;
						else
							length=4+(4-(lc%4));
						break;
					}
					else if(containsCode())
					{
						length=mots[k];
						break;
					}
					else if((word.contains("END"))||(word.contains("EQU"))||(word.contains("START"))||(word.contains("USING")))
						break;
					else
					{
						if(line.contains("EQU"))
						{
							String temp=s.next();
							lc1=s.nextInt();
						}
						else
							lc1=lc;
						p1.println(word+"\t"+lc1+"\t"+l1);
						sym[symc]=word;
						symval[symc]=""+lc1;
						symc++;
					}
				}
				lc=lc+length;
			}
			p1.close();
			p2.close();
			f3=new FileReader("ifa.txt");
			b3=new BufferedReader(f3);
			while((line=b3.readLine())!=null)
			{
				s=new Scanner(line);
				s.useDelimiter(",|\\s");
				while(s.hasNext())
				{
					word=s.next();
					if(word.equalsIgnoreCase("using"))
					{
						String a1;
						word=s.next();
						a1=s.next();
						if(word.equals("*"))
							word=""+0;
						if(containsSym(a1))
							a1=symval[k];
						i=Integer.parseInt(a1);
						i--;
						bt[i][1]="Y";
						bt[i][2]=word;
					}
				}
				if(containsSym(line))
					line=line.replace(sym[k],symval[k]);
				p4.println(line);
			}
			for(i=0;i<15;i++)
				p3.println(bt[i][0]+"\t"+bt[i][1]+"\t\t"+bt[i][2]);
			p3.close();
			p4.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
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
	static boolean containsSym(String a)
	{
		for(int i=0;i<symc;i++)
		{
			if(a.contains(sym[i]))
			{
				k=i;
				return true;
			}
		}
		return false;
	}
}
/*
Output:
Files:
*********************
-srca.txt
JOHN	START
	USING	*,15
	LOAD	1,FIVE
	ADD	1,4
	STORE	1,TEMP
FOUR 	DC	F,'4'
FIVE	DC	F,'5'
TEMP	DS	1,F
	END
*********************
-mot.txt
LOAD	4
STORE	4
ADD	4
*********************
-ifa.txt
LC	OPCODE	OPERAND
0	JOHN	START
0		USING	*,15
0		LOAD	1,FIVE
4		ADD	1,4
8		STORE	1,TEMP
12	FOUR 	DC	F,'4'
16	FIVE	DC	F,'5'
20	TEMP	DS	1,F
24		END
*********************
-st.txt
SYMBOL	VALUE	SIZE
JOHN	0	1
FOUR	12	4
FIVE	16	4
TEMP	20	4
*********************
-bt.txt
REG	AVAILABILITY	CONTENT
1	N			null
2	N			null
3	N			null
4	N			null
5	N			null
6	N			null
7	N			null
8	N			null
9	N			null
10	N			null
11	N			null
12	N			null
13	N			null
14	N			null
15	Y			0
*********************
-op.txt
LC	OPCODE	OPERAND
0	0	START
0		USING	*,15
0		LOAD	1,16
4		ADD	1,4
8		STORE	1,20
12	12 	DC	F,'4'
16	16	DC	F,'5'
20	20	DS	1,F
24		END
*********************
*/