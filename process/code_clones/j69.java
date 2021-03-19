class GFG { 
       
    public static int smallestKFreq(int a[], int n, int k) 
    { 
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>(); 
       
        // Map is used to store the count of 
        // elements present in the array 
        for (int i = 0; i < n; i ++) 
              
            if (m.containsKey(a[i])) 
                m.put(a[i], m.get(a[i]) + 1); 
          
           else m.put(a[i], 1); 
       
        // Traverse the map and find minimum 
        // element with frequency k. 
        int res = Integer.MAX_VALUE; 
        Set<Integer> s = m.keySet(); 
          
        for (int temp : s) 
            if (m.get(temp) == k) 
               res = Math.min(res, temp); 
       
        return (res != Integer.MAX_VALUE)? res : -1; 
    } 
      
    /* Driver program to test above function */
    public static void main(String[] args)  
    { 
        int arr[] = { 2, 2, 1, 3, 1 }; 
        int k = 2; 
          
        System.out.println(smallestKFreq(arr, arr.length, k)); 
       
    } 
  } 