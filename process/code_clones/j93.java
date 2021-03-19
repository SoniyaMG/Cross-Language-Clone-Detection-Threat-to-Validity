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
        int n1 = sc.nextInt();
		String s[] = new String[n1];
		for(int i=0;i<n1;i++)
		s[i]=sc.next();
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<s.length;i++){
		  //  System.out.println(s[i]);
		    if(s[i].equals("X")){
		        st.pop();
		    }
		    else if(s[i].equals("Y")){
		        int n = st.peek();
		        st.add(2*n);
		    }
		    else if(s[i].equals("+")){
		        int a = st.pop();
		        int b = st.pop();
		        st.add(b);
		        st.add(a);
		        st.add(a+b);
		    }
		    else{
		        int e = Integer.parseInt(s[i]);
		        st.add(e);
		    }
		}
		int sum =0;
		while(!st.isEmpty()){
		    sum+=st.peek();
		  //  System.out.println(sum);
		    st.pop();
		}
		System.out.println(sum);
	}
	
	
}