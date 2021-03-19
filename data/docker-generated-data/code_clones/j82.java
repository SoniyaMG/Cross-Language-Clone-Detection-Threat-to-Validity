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
			int N = Integer.parseInt(in.readLine().trim());
			String[] input = in.readLine().trim().split("\\s+");

		    Pair[] X = new Pair[N];
		    for (int i=0; i<N; i++)
		    {
		        X[i] = new Pair(Integer.parseInt(input[i]) , i+1);
		    }
		    
		    Stack<Pair> S = new Stack<>();
		    
		    for (int i=0; i<N; i++)
		    {
		        while (!S.empty() && X[i].weight<=S.peek().weight)
		            S.pop();
		        if (S.empty())
		            sss.append( "0 " );
		        else 
		            sss.append( S.peek().room+" " );
		        S.push( X[i] );
		    }
		}
		out.print( sss );
		in.close();	o_o.close();
	}   // ƒ(Main)
}
class Pair
{
    int weight, room;
    Pair (int a, int b)
    {
        weight = a;
        room = b;
    }
}