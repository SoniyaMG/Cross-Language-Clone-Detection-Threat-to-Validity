import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
    static void findAns(int arr[],int n){
            Arrays.sort(arr);
			LinkedList<Integer> q=new LinkedList<>();
			q.addFirst(arr[n-1]);
			q.addFirst(arr[n-2]);
			int i=n-3;
			while(i>=0){
				int num=q.pollLast();
				q.addFirst(num);
				q.addFirst(arr[i]);
				i--;
			}
			for(int k=0;k<q.size();k++)
				System.out.print(q.get(k)+" ");
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
	    findAns(arr,n);
			
	}
}