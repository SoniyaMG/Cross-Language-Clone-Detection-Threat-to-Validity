class GFG 
{     
    // Returns true if there is a pair in  
    // arr[0..n-1] with product equal to x.   
    boolean isProduct(int arr[], int n, int x) 
    { 
        for (int i=0; i<n-1; i++) 
            for (int j=i+1; j<n; j++) 
                if (arr[i]*arr[j] == x) 
                    return true; 
        return false; 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        GFG g = new GFG(); 
        int arr[] = {10, 20, 9, 40}; 
        int x = 400; 
        int n = arr.length; 
        if (g.isProduct(arr, n, x)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
  
        x = 190; 
        if (g.isProduct(arr, n, x)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
  
    } 
} 