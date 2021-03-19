public class GFG { 
  
    // Function to find pair whose 
    // sum exists in arr[] 
    static void findPair(int[] arr, int n) 
    { 
        boolean found = false; 
        for (int i = 0; i < n; i++) { 
            for (int j = i + 1; j < n; j++) { 
                for (int k = 0; k < n; k++) { 
                    if (arr[i] + arr[j] == arr[k]) { 
                        System.out.println(arr[i] +  
                                      " " + arr[j]); 
                        found = true; 
                    } 
                } 
            } 
        } 
  
        if (found == false) 
            System.out.println("Not exist"); 
    } 
  
    // Driver code 
    static public void main(String[] args) 
    { 
        int[] arr = {10, 4, 8, 13, 5}; 
        int n = arr.length; 
        findPair(arr, n); 
    } 
} 