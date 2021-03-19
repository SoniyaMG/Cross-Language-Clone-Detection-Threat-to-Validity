def maxDistance(arr, n): 
      
    # Used to store element to first index mapping 
    mp = {} 
  
    # Traverse elements and find maximum distance between 
    # same occurrences with the help of map. 
    maxDict = 0
    for i in range(n): 
  
        # If this is first occurrence of element, insert its 
        # index in map 
        if arr[i] not in mp.keys(): 
            mp[arr[i]] = i 
  
        # Else update max distance 
        else: 
            maxDict = max(maxDict, i-mp[arr[i]]) 
  
    return maxDict 
  
# Driver Program 
if __name__=='__main__': 
    arr = [3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2] 
    n = len(arr) 
    print maxDistance(arr, n) 