/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int a=0,b=0;
	    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    String temp = br.readLine();
	    String[] s1 = temp.split("\\s+");
	    temp = br.readLine();
	    String[] s2 = temp.split("\\s+");
	    
	    
	    if(Integer.parseInt(s1[0])>Integer.parseInt(s2[0])){a++;}else if(Integer.parseInt(s1[0])<Integer.parseInt(s2[0])){b++;}
if(Integer.parseInt(s1[1])>Integer.parseInt(s2[1])){a++;}else if(Integer.parseInt(s1[1])<Integer.parseInt(s2[1])){b++;}
if(Integer.parseInt(s1[2])>Integer.parseInt(s2[2])){a++;}else if(Integer.parseInt(s1[2])<Integer.parseInt(s2[2])){b++;}
	    System.out.println(a + " " + b);
	    
	    
	}
}
