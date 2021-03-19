import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import static java.lang.System.out;

class GURU// #_# //SHreYanSH
{
    public static void FX(String n, StringBuilder sss)
    {
        BigInteger big = BigInteger.valueOf(2);
        BigInteger N = new BigInteger(n);
        N = N.multiply( BigInteger.valueOf(31536000) );
        BigInteger mod = BigInteger.valueOf(1000000007);
        big = big.modPow(N, mod);
        sss.append( big+"\n" );
    }
	public static void main (String [] $__$) throws java.lang.Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter o_o = new PrintWriter(System.out);	// (O_x)
		StringBuilder sss = new StringBuilder("");
		
		int test = Integer.parseInt(in.readLine().trim());
		
		while (test-- > 0)
		{
			String n = in.readLine().trim();
		    FX( n , sss );
		}                                              /// [[TEST]]
		out.print( sss );
		in.close();	o_o.close();
	}   // ƒ(Main)
}