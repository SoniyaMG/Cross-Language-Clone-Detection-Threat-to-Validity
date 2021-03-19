/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int t = sc.nextInt(); t > 0; --t)
		{
		    long n = sc.nextInt();
		    System.out.println(safeSqrs(n)%1000000007);
		}
	}
	public static long safeSqrs(long n)
	{
		if(n <= 5) return 0;
		else
		{
			n = n - 2;
			n = (long)(Math.floor(n / 2));
			return ((long)(Math.floor(n * n / 2)));
		}
	}
}
