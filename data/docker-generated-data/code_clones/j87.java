/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.io.*;
import java.util.Arrays;

class Main
{
	public static void main(String[] args) throws Exception{
	    Solution obj = new Solution();
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(in.readLine().trim());
	    while(T-->0){
	        System.out.println(obj.solve(in.readLine().trim().split(" ")));
	    }
	    
	}
}

class Solution {
    int nums[] = new int[1000000];
    int M = 1000000007;
    Solution(){
        nums[0] = 0; nums[1] = 1;
        for(int i=1; i<1000000-1;i++){
            nums[i+1] = (nums[i]+nums[i-1])%M;
        }
    }
    String solve(String[] arr){
        int n = Integer.parseInt(arr[0]), m = Integer.parseInt(arr[1]);
        int i;
        // System.out.println(n+" dsf "+ m);
        // System.out.println(Arrays.toString(Arrays.copyOfRange(nums,0,n)));
        
        StringBuilder s = new StringBuilder();
        int rev = 0, front = 0;
        for(i = 0 ; i<m;i++){
            if ((i&1)==0){
                s.append(nums[front]);
                front++;
            } else {
                s.append(nums[n - 1 - rev]);
                rev++;
            }
            s.append(" ");
        }
        return s.toString().trim();
    //     n,m=[int(x) for x in sys.stdin.readline().split()]
    // f=[0,1]
    // a=0 
    // b=1 
    
    // for i in range(1,n):
    //     f.append((f[i]+f[i-1]))
    // p=[]
    // i=0
    
    // for count in range(m):
    //     if count%2==0:
    //         p.append(str(f[i]%1000000007))
    //     else:
    //         p.append(str(f[n-1-i]%1000000007))
    //         i+=1 
    // ans = " "
    // print(*p)
    }
    
}