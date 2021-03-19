def findMissing(a, b, n, m): 
  
    for i in range(n): 
        for j in range(m): 
            if (a[i] == b[j]): 
                break
  
        if (j == m - 1): 
            print(a[i], end = " ") 
  
# Driver code 
if __name__ == "__main__": 
      
    a = [ 1, 2, 6, 3, 4, 5 ] 
    b = [ 2, 4, 3, 1, 0 ] 
    n = len(a) 
    m = len(b) 
    findMissing(a, b, n, m) 