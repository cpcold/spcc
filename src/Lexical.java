import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.util.Scanner;

public class Lexical 
{
    public static void main(String[] args)throws FileNotFoundException
    {
        try 
        {
            FileReader fp = new FileReader("source.txt");
            FileWriter fw=new FileWriter("output.txt");
            BufferedReader br=new BufferedReader(fp);
            BufferedWriter bw=new BufferedWriter(fw);
         //   String output =new Scanner(new File("file1.txt"));

            String line;
            bw.write("Symbol\t\t\t");
            bw.write("LS\n");
            while((line=br.readLine())!=null)
            {
               // System.out.println("mi alo");
                if(line.contains("{") )
                {
                    System.out.println("\nOpening of method:\t");
                    bw.write("{");
                }
                if(line.contains("int") )
                {
                    bw.write("\nKeyword orr Datatype:\t");
                    bw.write("int");
                }
                if(line.contains(";") )
                {
                    bw.write("\nDelimeter:\t\t");
                    bw.write(";");
                }
                if(line.contains("}") )
                {
                    bw.write("\nClosing of method:\t");
                    bw.write("}");
                }
                if(line.contains("a") )
                {
                    bw.write("\nvariable:\t\t");
                    bw.write("\ta");
                }
                if(line.contains("b") )
                {
                    bw.write("\nvariable:\t\t");
                    bw.write("\tb");
                }
                if(line.contains("c") )
                {
                    bw.write("\nvariable:\t\t");
                    bw.write("\tc");
                }
            }
            bw.close();
        } 
        catch (Exception ex) {
            //Logger.getLogger(Lexical.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
