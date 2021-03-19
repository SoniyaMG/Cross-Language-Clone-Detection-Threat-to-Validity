/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
  
    static void merge(int arr[], int beg, int mid, int end)  
    {  
          
        int l = mid - beg + 1;  
        int r = end - mid;  
  
        int LeftArray[] = new int [l];  
        int RightArray[] = new int [r];  
  
        for (int i=0; i<l; ++i)  
        LeftArray[i] = arr[beg + i];  
          
        for (int j=0; j<r; ++j)  
        RightArray[j] = arr[mid + 1+ j];  
          
      
        int i = 0, j = 0;  
        int k = beg;  
        while (i<l&&j<r)  
        {  
        if (LeftArray[i] <= RightArray[j])  
        {  
            arr[k] = LeftArray[i];  
            i++;  
        }  
        else  
        {  
            arr[k] = RightArray[j];  
            j++;  
        }  
            k++;  
        }  
while (i<l)  
{  
arr[k] = LeftArray[i];  
i++;  
k++;  
}  
  
while (j<r)  
{  
arr[k] = RightArray[j];  
j++;  
k++;  
}  
}  
  
static void sort(int arr[], int beg, int end)  
{  
if (beg<end)  
{  
int mid = (beg+end)/2;  
sort(arr, beg, mid);  
sort(arr , mid+1, end);  
merge(arr, beg, mid, end);  
}  
}  
    
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		int n=Integer.parseInt(str[0]);
		int m=Integer.parseInt(str[1]);
		int k=Integer.parseInt(str[2]);
		int student[]=new int[n];
		int room[]=new int[m];
		str=br.readLine().split(" ");
		for( int i=0;i<n;i++)
		{
		    student[i]=Integer.parseInt(str[i]);
		}
		str=br.readLine().split(" ");
		for( int i=0;i<m;i++)
		{
		    room[i]=Integer.parseInt(str[i]);
		}
		sort(room,0, m-1);
		sort(student, 0, n-1);
		int i=0, j=0, count=0;
		while(i<m && j<n)
		{
		    if(room[i]<=student[j]+k && room[i]>=student[j]-k)
		    {
		        count++;
		        i++;
		        j++;
		    }
		    else if(room[i]>student[j]+k)
		        j++;
		    else if(room[i]<student[j]-k)
		        i++;
		}
		System.out.println(count);
	}
}
