def minDist(arr, n, x, y): 
    min_dist = 99999999
    for i in range(n): 
        for j in range(i + 1, n): 
            if (x == arr[i] and y == arr[j] or
            y == arr[i] and x == arr[j]) and min_dist > abs(i-j): 
                min_dist = abs(i-j) 
        return min_dist 
  
  
# Driver code 
arr = [3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3] 
n = len(arr) 
x = 3
y = 6
print("Minimum distance between ",x," and ", 
     y,"is",minDist(arr, n, x, y)) 