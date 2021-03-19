/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void r1(int total)
    {
            int r=0,sum=0;
            while(total>0)
            {
            r=total%10;
            sum+=r;
            total/=10;
            }
            int temp=sum;
        
            if(temp>9)
              r1(temp);

            else

                System.out.println(temp);
  
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    String s=sc.next();
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    int l=s.length();
		    int sum=0;
		    int sum1=0;
		    for(int i=0;i<l;i++)
		    {
		        if(i%2==0)

		            sum+=((int)s.charAt(i)-48)*a;
		        
		        else
		            sum1+=((int)s.charAt(i)-48)*b;
		    }
		 
		    int total=sum+sum1;
		    r1(total);
		    
		}
	}
}