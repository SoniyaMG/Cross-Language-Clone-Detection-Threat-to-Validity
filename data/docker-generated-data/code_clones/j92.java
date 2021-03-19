import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.*;

// Remember that the class name should be "Main" and should be "public".
public class Main {

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
				    tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
				    throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() { 
		    return Long.parseLong(next()); 
		}
		
		public double nextDouble()
        {
            return Double.parseDouble(next());
        }
        
        public String nextLine()
        {
            String str = "";
            try {
                str = reader.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
	}
	
	
	public static void main(String[] args) {
		// System.in and System.out are input and output streams, respectively.
		InputStream inputStream = System.in;
        InputReader sc = new InputReader(inputStream);
		    int n = sc.nextInt();
		    HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		    int a[] = new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		    }
		    for(int p:a){
		        if(hm.get(p)==null)
		        hm.put(p,1);
		        else
		        hm.put(p,hm.get(p)+1);
		    }
		    for(Map.Entry h : hm.entrySet()){
		        int hi = (int)h.getValue();
		        if(hi>=(n/2))
		        {
		            System.out.println(h.getKey());
		            break;
		        }
		}
	}
	
	
}