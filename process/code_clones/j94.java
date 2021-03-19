import java.io.*;
import java.util.*;
import java.lang.*;
import static java.lang.System.out;

class GURU// #_# //SHreYanSH
{
	public static void main (String [] $__$) throws java.lang.Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter o_o = new PrintWriter(System.out);	// (O_x)
		StringBuilder sss = new StringBuilder("");
		
		int test = 1;
		
		while (test-- > 0)
		{
			String[] input = in.readLine().trim().split("\\s+");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);

            String[] array = in.readLine().trim().split("\\s+");
            Stack<Long> stack = new Stack<Long>();
		    for (int i=n-1; 0<=i; i--)
		    {
		        stack.push( Long.parseLong(array[i]) );
		    }
		    
		    long max = -1;
		    if ( n==1 && k%2==0 )
		        max = stack.pop();
		    else if ( n==1 && k%2==1 )
		        max = -1;
		    else if ( n<=k )
		    {
		        for (int i=0; i<n; i++)
		            max = Math.max( stack.elementAt(i) , max );
		    }
		    else 
		    {
		        for (int i=1; i<=k-1; i++)
		            max = Math.max( stack.pop() , max );
		        max = Math.max( stack.pop() , max );
		    }
		    
			sss.append(max+"\n");
		}                                              /// [[TEST]]
		out.print( sss );
		in.close();	o_o.close();
	}   // ƒ(Main)
}