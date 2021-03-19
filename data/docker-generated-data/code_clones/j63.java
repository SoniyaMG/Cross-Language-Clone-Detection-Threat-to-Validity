class GFG  
{ 
    static int printKDistinct(int arr[],  
                                  int n,  
                                  int k) 
    { 
        int dist_count = 0; 
        for (int i = 0; i < n; i++) 
        { 
              
            int j; 
              
            for (j = 0; j < n; j++) 
                if (i != j && arr[j] == arr[i]) 
                    break; 

            if (j == n) 
                dist_count++; 
      
            if (dist_count == k) 
                return arr[i]; 
        } 
      
        return -1; 
    } 

    public static void main (String[] args) 
    { 
          
        int ar[] = {1, 2, 1, 3, 4, 2}; 
        int n = ar.length; 
        int k = 2; 
          
        System.out.print(printKDistinct(ar, n, k)); 
    } 
} 