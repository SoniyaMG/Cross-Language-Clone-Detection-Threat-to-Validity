def checkDuplicatesWithinK(arr, n, k): 
  
    # Creates an empty list 
    myset = [] 
  
    # Traverse the input array 
    for i in range(n): 
      
        # If already present n hash, then we  
        # found a duplicate within k distance 
        if arr[i] in myset: 
            return True
  
        # Add this item to hashset 
        myset.append(arr[i]) 
  
        # Remove the k+1 distant item 
        if (i >= k): 
            myset.remove(arr[i - k]) 
    return False
  
# Driver Code 
if __name__ == "__main__": 
      
    arr = [10, 5, 3, 4, 3, 5, 6] 
    n = len(arr) 
    if (checkDuplicatesWithinK(arr, n, 3)): 
        print("Yes") 
    else: 
        print("No") 