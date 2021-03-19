import java.util.*;
import java.io.*;
public class Main{

	public static void main(String[] args) throws IOException{
		try {
			Scanner sc = new Scanner(System.in);
			int t=sc.nextInt();
			while(t>0) {
				int n=sc.nextInt();
				int arr[]=new int[n];
				for(int i=0;i<arr.length;i++) {
					arr[i]=sc.nextInt();
				}
				int maxSum=arr[0];
				int currSum=arr[0];
				
				for(int j=1;j<arr.length;j++) {
					currSum = Math.max(arr[j], currSum+arr[j]);
			        maxSum = Math.max(maxSum, currSum);
				}
				System.out.println(maxSum);
				t--;
				
			}
		}
		catch(Exception e) {
			return;
		}
	}

}
