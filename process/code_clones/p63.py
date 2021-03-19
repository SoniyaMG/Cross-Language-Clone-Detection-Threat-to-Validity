def printKDistinct(arr, n, k): 
    dist_count = 0
    for i in range(n): 
          
        # Check if current element is 
        # present somewhere else. 
        j = 0
        while j < n: 
            if (i != j and arr[j] == arr[i]): 
                break
            j += 1
  
        # If element is unique 
        if (j == n): 
            dist_count += 1
  
        if (dist_count == k): 
            return arr[i] 
  
    return -1
  
# Driver Code 
ar = [1, 2, 1, 3, 4, 2] 
n = len(ar) 
k = 2
print(printKDistinct(ar, n, k)) 