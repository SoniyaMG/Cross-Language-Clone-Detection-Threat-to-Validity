/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner foo = new Scanner(System.in);
		int t=foo.nextInt();
		for(int q=0;q<t;q++){
		    int n =foo.nextInt();
		    int a[][] = new int[n][3];
		    for(int i=0;i<n;i++){
		        for(int j=0;j<3;j++){
		            a[i][j] = foo.nextInt();
		        }
		    }
		    int count=0;
		    for(int i=0;i<n;i++){
		        for(int j=0;(j<n);j++){
		            double t1 = Math.pow(Math.pow((a[j][0]-a[i][0]),2) + Math.pow((a[j][1]-a[i][1]),2),0.5);
		            double t2 = (double)(a[j][2]+a[i][2]);
		          //  System.out.println(t1);
		          //  System.out.println(t2);
		            if(t1<t2 && t1!=0 && j!=i){
		              //  System.out.println(i);
		              //  double tt1=0;
		              //  System.out.println("dfsffsdfsdfsdfsdfsfsdfs");
		              //  double tt2=0;
		                for(int k=0;(k<n);k++){
		                double w = Math.pow(Math.pow((a[k][0]-a[j][0]),2) + Math.pow((a[k][1]-a[j][1]),2),0.5);
		                double e = Math.pow(Math.pow((a[k][0]-a[i][0]),2) + Math.pow((a[k][1]-a[i][1]),2),0.5);
		              //  System.out.println(k);
		              //  System.out.println(e);
		                
		                if(w==a[k][2] && w!=0 && e!=0 && e==a[k][2] && k!=j && k!=i){
		              //  System.out.println("dfsffsdfsdfsdfsdfsfsdfs");
		                  //System.out.println(i+" "+j+" "+k);
		                    count++;
		                }
		            }
		            }
		        }
		    }
		    System.out.println(count/2);
		    
		}
		
	}
}
