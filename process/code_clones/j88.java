import java.util.*;
import java.io.*;
class contest
{
    static ArrayList<String> ans;
    public static void permute(String a,String b)
    {
        if (a.length() == 0) 
        { 
            ans.add(b);
            return; 
        }
        for (int i = 0; i < a.length(); i++) 
        {
            char ch=a.charAt(i);
            String ros=a.substring(0, i)+a.substring(i + 1); 
            permute(ros, b+ch); 
        } 
    }
    public static void main(String args[]) throws IOException
    {
        try{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=0;
        t=Integer.parseInt(br.readLine());
        while(t-->0)
        {
            int n=0;
            n=Integer.parseInt(br.readLine());
            String str="";
            str=br.readLine().trim();
            HashSet<Character> set=new HashSet<Character>();
            for(char s:str.toCharArray())
            {
                set.add(s);
            }
            String req="";
            for(char tg:set)
                req+=tg;
            ans=new ArrayList<String>();
            permute(req,"");
            Collections.sort(ans);
            StringBuilder as=new StringBuilder();
            as.append(ans.size()+"\n");
            for(String jn:ans)
                as.append(jn+" ");
            System.out.println(as);
        }
    }
    catch(Exception e){}
}}