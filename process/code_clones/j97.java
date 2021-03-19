import java.util.*;
import java.math.BigInteger;
import java.util.*;

class Codechef
{
//	  public static int calsum(int arr[],int n,int k) {
//		  int sum=arr[k];
//		  for(int i=k+1;i<n;i++) {
//			  if(arr[i-1]<arr[i]) {
//				  sum=sum+arr[i];
//			  }
//		  }
//		  return sum;
//	  }
	static int maxSumIS(int arr[], int n) 
    { 
        int i, j, max = 0; 
        int msis[] = new int[n]; 
  
        /* Initialize msis values  
           for all indexes */
        for (i = 0; i < n; i++) 
            msis[i] = arr[i]; 
  
        /* Compute maximum sum values 
           in bottom up manner */
        for (i = 1; i < n; i++) 
            for (j = 0; j < i; j++) 
                if (arr[i] > arr[j] && 
                    msis[i] < msis[j] + arr[i]) 
                    msis[i] = msis[j] + arr[i]; 
  
        /* Pick maximum of all 
           msis values */
        for (i = 0; i < n; i++) 
            if (max < msis[i]) 
                max = msis[i]; 
  
        return max; 
    } 
	
	public static void main(String args[]) {
		
		 try {
			 Scanner sc=new Scanner(System.in);
				int t=sc.nextInt();
				sc.nextLine();

			while(t-->0) {
				int n=sc.nextInt();
				int a[]=new int [n];
				for(int i=0;i<n;i++) {
					a[i]=sc.nextInt();
				}
//			int result=0;	
//			for(int i=0;i<n;i++) {
//				result=Math.max(result,calsum(a,a.length,i));
//			}
//			System.out.println(result);	
			System.out.println(maxSumIS(a, n)); 
				
				
			}
			
		  
		 }
		    	
		      
		      
		catch(Exception e) {
			System.out.println(e);
		}
		     
	 }	       
		     
}	 



	
