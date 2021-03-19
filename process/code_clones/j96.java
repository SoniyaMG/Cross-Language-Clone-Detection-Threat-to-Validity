
import java.util.Scanner;
 class ATM
{
    public static void main(String args[])
    {
        Scanner in=(new Scanner(System.in));
        int test=in.nextInt();
        while(test--!=0){
               int n=in.nextInt();
               int no=(int)Math.log10(n)+1;
               int sum=0;
               while(n>0){
                     int  rem=n%10;
                      sum+=rem;
                      n/=10;
               }
               if(sum%no==0)
               System.out.println("Good Work");
               else
               System.out.println("Try again");
        }
}
}