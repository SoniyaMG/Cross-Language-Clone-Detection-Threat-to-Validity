def smallestKFreq(arr, n, k): 
    mp = defaultdict(lambda : 0) 
  
  
    # Map is used to store the count of  
    # elements present in the array  
    for i in range(n): 
        mp[arr[i]] += 1
  
    # Traverse the map and find minimum  
    # element with frequency k.  
    res = sys.maxsize 
    res1 = sys.maxsize 
  
    for key,values in mp.items(): 
  
        if values == k: 
            res = min(res, key) 
    return res if res != res1 else -1
  
# Driver code 
arr = [2, 2, 1, 3, 1] 
k = 2
n = len(arr) 
print(smallestKFreq(arr, n, k))