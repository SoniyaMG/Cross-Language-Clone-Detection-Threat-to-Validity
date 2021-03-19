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
		
		int test = Integer.parseInt(in.readLine().trim());
		
		while (test-- > 0)
		{
			String[] input = in.readLine().trim().split("\\s+");
			int n = Integer.parseInt(input[0]);
			int d = Integer.parseInt(input[1]);

            String[] array = in.readLine().trim().split("\\s+");
            Set<Integer> set = new HashSet<Integer>();
		    Stack<Integer> x = new Stack<Integer>();
		    int day = 0;
		    for (int i=0; i<n; i++)
		    {
		        x.push( Integer.parseInt(array[i]) );
		    }
		    for (day=d; 1<=day; day--)
		    {
		        while ( !x.isEmpty() && day%x.peek() == 0 )
		            x.pop();
		        if ( x.size() == 0 )
		            break;
		    }
		    
			sss.append(day+"\n");
		}
		out.print( sss );
		in.close();	o_o.close();
	}   // ƒ(Main)
}