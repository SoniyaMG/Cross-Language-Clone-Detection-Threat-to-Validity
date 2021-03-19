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
  int a[][]=new int[6][6];
  for(int i=0;i<6;i++)
  {
  for(int j=0;j<6;j++)
  {
  a[i][j]=sc.nextInt();
  }
  }
  boolean bool[][]=new boolean [6][6];
  for(int i=5;i>=0;i--)
  {
  for(int j=5;j>=0;j--)
  {
  if(i==5&&j==5)
  {
  if(a[i][j]==1)
  bool[i][j]=false;
  else
  bool[i][j]=true;
  }
  else if(i==5)
  {
  bool[i][j]=bool[i][j]|bool[i][j+1];
  }
  else if(j==5)
  {
  bool[i][j]=bool[i][j]|bool[i+1][j];
  }
  else
  {
  bool[i][j]=(bool[i][j]|bool[i+1][j])|(bool[i][j]|bool[i][j+1]);
  }
  }
  }
 
  if(bool[0][0]==true)
  System.out.println("YES");
  else
  System.out.println("NO");
}
}
















