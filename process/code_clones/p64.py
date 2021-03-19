def isProduct(arr, n, x): 
    for i in arr: 
        for j in arr: 
            if i * j == x: 
                return True
    return False
      
      
# Driver code      
arr = [10, 20, 9, 40] 
x = 400
n = len(arr) 
if(isProduct(arr,n, x) == True): 
    print ("Yes") 
  
else: 
    print("No") 
      
x = 900
if(isProduct(arr, n, x)): 
    print("Yes") 
      
else: 
    print("No") 