import java.util.*;
import java.io.*;
import java.lang.*;

class Main{
    public static void main(String[] args) throws Exception{
        new Main().Ascii();
    }
    
    public static void Ascii() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while(T-->0){
            String S = in.readLine();
            String[] split = S.trim().split("\\s+");
            int K = Integer.parseInt(in.readLine());
            int sum1 = 0, sum2 = 0, temp = 0, temp2 = 0;
            boolean flag = true; 
            for(int i=0; i<split[0].length();i++){
                temp = split[0].charAt(i);
                temp2 = split[1].charAt(i);
                sum1 += temp;
                sum2 += temp2;
                if(Math.abs(temp-temp2)>K){
                    flag = false;
                    break;
                }
            }
            if(sum1 != sum2) flag = false;
            if(flag == true) out.println("WIN");
            else out.println("LOSE");
            
        }
        in.close();
        out.close();
    }
}