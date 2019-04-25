
import java.util.Scanner;


public class RecursivedecParser {
    static String input;
    static int i;
    public static void main(String[] args) {
        System.out.println("Grammer : S->aSB/e  \n B-> b/e \n");
        System.out.println("Input String");
        Scanner sc =new Scanner(System.in);
        input = sc.nextLine();
        i=0;
        input = input +"$";
        S();
    }
    
    
    public static void S()
    {
        if(input.charAt(i)=='a')
        {
            i++;
            B();
            if(i>0)
            {
               
                    if(input.charAt(i)!='$')
                        System.out.println("String is accepted");
                    
                    else
                    {
                        System.out.println("String is accepted");
                        System.exit(0);
                    }
                }
               else{
                   System.out.println("String is invalid");
                   System.exit(0);
               }
               }
            
        
        else
        {
            System.out.println("String is invalid");
            System.exit(0);
        }
    }
    
    public static void B(){
    
        if(input.charAt(i)=='a'){
        
            i++;
            B();
        }
        else if(input.charAt(i)=='b')
        {
            i++;
            if(input.charAt(i)!='$')
                B();
        }
        else
        {
            System.out.println("String is invalid");
            System.exit(0);
        }
    }
}
