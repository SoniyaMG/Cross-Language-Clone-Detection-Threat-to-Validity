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
		
		String[] input = in.readLine().trim().split("\\s+");
		int N = Integer.parseInt(input[0]);
		int Q = Integer.parseInt(input[1]);
		
		String[] array = in.readLine().trim().split("\\s+");
		long[] A = new long[N];
		long[] T = new long[N];
		for (int i=0; i<N; i++)
		    A[i] = Long.parseLong(array[i]);
		
		Arrays.fill( T , 0 );
		for (int i=N-1; 1<=i; i--)
		    A[i] = A[i] - A[i-1];
		
		while (Q-- > 0)
		{
			String[] query = in.readLine().trim().split("\\s+");
			int L = Integer.parseInt(query[0]) - 1;
		    int R = Integer.parseInt(query[1]) - 1;
		    long I = Long.parseLong(query[2]);
		    
		    T[L] -= I;
		    if (R<N-1)
		    T[R+1] += I;
		}
		for (int i=1; i<N; i++)
		    T[i] = T[i-1] + T[i];
		for (int i=0; i<N; i++)
		    sss.append(A[i]+T[i]+" ");
	    
		out.print( sss );
		in.close();	o_o.close();
	}   // ƒ(Main)
}
// https://www.geeksforgeeks.org/constant-time-range-add-operation-array/