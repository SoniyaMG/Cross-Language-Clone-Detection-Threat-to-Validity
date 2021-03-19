class GFG{ 
  
static int findGreatest( int []arr , int n) 
{ 
    int result = -1; 
    for (int i = 0; i < n ; i++) 
        for (int j = 0; j < n-1; j++) 
            for (int k = j+1 ; k < n ; k++) 
                if (arr[j] * arr[k] == arr[i]) 
                    result = Math.max(result, arr[i]); 
    return result; 
} 
  
    // Driver code 
    static public void main (String[] args) 
    { 
        int []arr = {30, 10, 9, 3, 35}; 
        int n = arr.length; 
  
        System.out.println(findGreatest(arr, n)); 
    } 
} 