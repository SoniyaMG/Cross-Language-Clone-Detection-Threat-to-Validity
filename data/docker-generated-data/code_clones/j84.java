import java.util.*;
import java.io.*;
import java.text.*;

public class Main{
    //SOLUTION BEGIN
    //Into the Hardware Mode
    void pre() throws Exception{}
    void solve(int TC) throws Exception {
        int N = ni(), K = ni(), ty = ni();
        int[] A = new int[1+N];
        for(int i = 1; i<= N; i++)A[i] = ni();
        int Q = ni();
        int[][] qu = new int[Q][];
        for(int i = 0; i< Q; i++)qu[i] = new int[]{ni(), ni()};
        if(ty == 1){
            int[] sum = new int[2+N];
            sum[1]++;
            sum[N+1]--;
            for(int[] q:qu){
                sum[q[0]]--;
                sum[q[1]+1]++;
            }
            boolean yes = true;
            long total = 0;
            for(int i = 1; i<= N+1; i++){
                sum[i] += sum[i-1];
                if(sum[i] == 0 && sum[i-1] == 1)
                    yes &= total == 0;
                if(i == N+1)break;
                total += A[i];
                if(sum[i] == 1)total -= Math.min(total, K);
            }
            pn(yes?"YES":"NO");
        }else{
            long[] non = new long[2+N];
            for(int i = 1; i<= N; i++)non[i] = K-A[i];
            for(int i = N-1; i>= 0; i--)non[i] += non[i+1];

            boolean yes = true;
            SegmentTree st = new SegmentTree(A);
            for(int[] q:qu)
                yes &= non[q[1]+1] >= st.query(q[0], q[1]);

            pn(yes?"YES":"NO");
        }
    }
    class SegmentTree{
        private long initValue(){return 0;}
        private long update(long oldValue, long newValue){return oldValue+newValue;}
        private long merge(long le, long ri){return le+ri;}
        private long initQuery(){return 0;}

        private int m= 1;
        private long[] t;
        public SegmentTree(int n){
            while(m<n)m<<=1;
            t = new long[m<<1];
            Arrays.fill(t, initValue());
        }
        public SegmentTree(int[] a){
            while(m<a.length)m<<=1;
            t = new long[m<<1];
            Arrays.fill(t, initValue());
            for(int i = 0; i< a.length; i++)t[i+m] = a[i];
            for(int i = m-1; i>0; i--)t[i] = merge(t[i<<1], t[i<<1|1]);
        }
        public void update(int i, long val){
            t[i += m]  = update(t[i], val);
            for(i>>=1;i>0;i>>=1)t[i] = merge(t[i<<1], t[i<<1|1]);
        }
        public long query(int l, int r){
            long lans = initQuery(), rans = initQuery();
            for(l+=m,r+=m+1;l<r;l>>=1,r>>=1){
                if((l&1)==1)lans = merge(lans, t[l++]);
                if((r&1)==1)rans = merge(t[--r], rans);
            }
            return merge(lans, rans);
        }
    }
    //SOLUTION  END
    void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    void exit(boolean b){if(!b)System.exit(0);}
    static void dbg(Object... o){System.err.println(Arrays.deepToString(o));}
    final long IINF = (long)1e17;
    final int INF = (int)1e9+2;
    DecimalFormat df = new DecimalFormat("0.000000000");
    double PI = 3.141592653589793238462643383279502884197169399, eps = 1e-9;
    static boolean multipleTC = true, memory = true, fileIO = false;
    FastReader in;PrintWriter out;
    void run() throws Exception{
        long ct = System.currentTimeMillis();
        if (fileIO) {
            in = new FastReader("");
            out = new PrintWriter("");
        } else {
            in = new FastReader();
            out = new PrintWriter(System.out);
        }
        //Solution Credits: Taranpreet Singh
        int T = multipleTC? ni():1;
        pre();
        for (int t = 1; t <= T; t++) solve(t);
        out.flush();
        out.close();
        System.err.println(System.currentTimeMillis() - ct);
    }
    public static void main(String[] args) throws Exception{
        if(memory)new Thread(null, new Runnable() {public void run(){try{new Main().run();}catch(Exception e){e.printStackTrace();System.exit(1);}}}, "1", 1 << 28).start();
        else new Main().run();
    }
    int[][] make(int n, int e, int[] from, int[] to, boolean f){
        int[][] g = new int[n][];int[]cnt = new int[n];
        for(int i = 0; i< e; i++){
            cnt[from[i]]++;
            if(f)cnt[to[i]]++;
        }
        for(int i = 0; i< n; i++)g[i] = new int[cnt[i]];
        for(int i = 0; i< e; i++){
            g[from[i]][--cnt[from[i]]] = to[i];
            if(f)g[to[i]][--cnt[to[i]]] = from[i];
        }
        return g;
    }
    int[][][] makeS(int n, int e, int[] from, int[] to, boolean f){
        int[][][] g = new int[n][][];int[]cnt = new int[n];
        for(int i = 0; i< e; i++){
            cnt[from[i]]++;
            if(f)cnt[to[i]]++;
        }
        for(int i = 0; i< n; i++)g[i] = new int[cnt[i]][];
        for(int i = 0; i< e; i++){
            g[from[i]][--cnt[from[i]]] = new int[]{to[i], i, 1};
            if(f)g[to[i]][--cnt[to[i]]] = new int[]{from[i], i, -1};
        }
        return g;
    }
    int[][] make(int n, int[] par, boolean f){
        int[][] g = new int[n][];
        int[] cnt = new int[n];
        for(int x:par)cnt[x]++;
        if(f)for(int i = 1; i< n; i++)cnt[i]++;
        for(int i = 0; i< n; i++)g[i] = new int[cnt[i]];
        for(int i = 1; i< n-1; i++){
            g[par[i]][--cnt[par[i]]] = i;
            if(f)g[i][--cnt[i]] = par[i];
        }
        return g;
    }
    int find(int[] set, int u){return set[u] = (set[u] == u?u:find(set, set[u]));}
    int digit(long s){int ans = 0;while(s>0){s/=10;ans++;}return ans;}
    long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
    int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
    int bit(long n){return (n==0)?0:(1+bit(n&(n-1)));}
    void p(Object... o){for(Object oo:o)out.print(oo+" ");}
    void pn(Object... o){
        if(o.length == 0)out.println("");
        for(int i = 0; i< o.length; i++){
            out.print(o[i]);
            out.print((i+1 == o.length?"\n":" "));
        }
    }
    void pni(Object... o){for(Object oo:o)out.print(oo+" ");out.println();out.flush();}
    String n()throws Exception{return in.next();}
    String nln()throws Exception{return in.nextLine();}
    int ni()throws Exception{return Integer.parseInt(in.next());}
    long nl()throws Exception{return Long.parseLong(in.next());}
    double nd()throws Exception{return Double.parseDouble(in.next());}
    class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception{
            br = new BufferedReader(new FileReader(s));
        }

        String next() throws Exception{
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        String nextLine() throws Exception{
            String str;
            try{
                str = br.readLine();
            }catch (IOException e){
                throw new Exception(e.toString());
            }
            return str;
        }
    }
}