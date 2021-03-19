    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;
    import java.util.StringTokenizer;
    public class Main
    {
    static class FastReader
    {
    BufferedReader br;
    StringTokenizer st;
    public FastReader()
    {
    br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next()
    {
    while (st == null || !st.hasMoreElements())
    {
    try{
    st = new StringTokenizer(br.readLine());
    }
    catch (IOException e)
    {
    e.printStackTrace(); }
    }
    return st.nextToken();
     
    }
    int nextInt()
    {
    return Integer.parseInt(next());
    }
    long nextLong()
    {
    return Long.parseLong(next());
    }
    double nextDouble()
    {
    return Double.parseDouble(next());
    }
    String nextLine()
    {
    String str = "";
    try
    {
    str = br.readLine();
    }
    catch (IOException e)
    {
    e.printStackTrace();
    }
    return str;
    }
    int[] a(int n) {
    int[] a=new int[n];
    for (int i=0; i<n; i++) a[i]=nextInt();
    return a;
    		}
    }
    //gaurav
    /*
 static class edge{
 int src;
 int des;
 edge(int src,int des)
 {
 this.src=src;
 this.des=des;
 }
 }
 static class pair{
 int v;
 String psf;
 pair(int v,String pfs)
 {
 this.v=v;
 this.psf=psf;
 }
 }*/
 
    public static void main(String[] args)throws Exception
    {
    FastReader sc=new FastReader();
    //gaurav
 int t=sc.nextInt();
 while(t-->0)
 {
 int n=sc.nextInt();
 int sum=0;
 int a[]=new int[n];
 for(int i=0;i<n;i++)
 {
 a[i]=sc.nextInt();
 sum=sum+a[i];
 }
 boolean bool=false;
 for(int i=0;i<n;i++)
 {
 int newsum=sum-a[i];
 if(newsum<=a[i])
 bool=true;
 }
 if(bool==true)
 System.out.println("NO");
 else
 System.out.println("YES");
 
 }
 
}
}
















