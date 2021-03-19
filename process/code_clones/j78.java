import java.io.*;
import java.util.*;
import java.lang.*;
import static java.lang.System.out;

class GURU// #_# //SHreYanSH
{
    public static int FX(List<Pair> DP, int n, int m, int s)
    {
        Collections.sort( DP );
      /*int[][] minMAX = new int[n][2];
        int L=0, R=n-1;
        for (int i=n-1; 0<=i; --i)
        {
            if ( i%2==0 )
            {
                minMAX[i][0] = DP.get(R).d;
                minMAX[i][1] = DP.get(R--).p;
            }
            else 
            {
                minMAX[i][0] = DP.get(L).d;
                minMAX[i][1] = DP.get(L++).p;
            }
        }*/
        int k = 0;
        int[] increasingDiff = new int[s];
        for (int i=0; i<n; i++)
            for (int j=1; j<=DP.get(i).p; j++)
                increasingDiff[k++] = DP.get(i).d;

        //int i=1;
        int minDiff = Integer.MAX_VALUE;
        for (int i=0; i<=(s-m); i++)
        {
            int curSeqDiff = increasingDiff[i+m-1] - increasingDiff[i];
            minDiff = Math.min(minDiff, curSeqDiff);
        }
        /*
        while ( i<n && 0<(m -= minMAX[i-1][1]) )
        {
            minDiff = Math.max(Math.abs(minMAX[i-1][0]-minMAX[i][0]) , minDiff);
            ++i;
        }*/
        return minDiff;
    }
	public static void main (String [] $__$) throws java.lang.Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter o_o = new PrintWriter(System.out);	// (O_x)
		StringBuilder sss = new StringBuilder("");
		
		int test = Integer.parseInt(in.readLine().trim());
		
		while (test-- > 0)
		{
			int m = Integer.parseInt(in.readLine().trim());
			int n = Integer.parseInt(in.readLine().trim());

            int s = 0;
            int maxP = 0;
		    int[] D = new int[n];
		    int[] P = new int[n];
		    List<Pair> DP = new ArrayList<>();
		    for (int i=0; i<n; i++)
		    {
		        String[] input = in.readLine().trim().split("\\s+");
		        D[i] = Integer.parseInt(input[0]);
		        P[i] = Integer.parseInt(input[1]);
		        maxP = Math.max( P[i] , maxP );
		        DP.add( new Pair(D[i] , P[i]));
		        s += P[i];
		    }
		    
			int result = 0;
			if ( maxP < m )
			    result = FX( DP,n,m,s );
			sss.append(result+"\n");
		}
		out.print( sss );
		in.close();	o_o.close();
	}   // ƒ(Main)
}
class Pair implements Comparable<Pair>
{
    int d, p;
    Pair (int x, int y)
    {
        d = x;
        p = y;
    }
    public int compareTo(Pair that)
    {
        if (this.d == that.d)
        {
            return that.p-this.p; 
        }
        return this.d-that.d;
    }
}