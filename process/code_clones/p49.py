def multiplyBySeven(n): 
  
    # Note the inner bracket here.  
    # This is needed because  
    # precedence of '-' operator is  
    # higher than '<<'  
    return ((n << 3) - n) 
  
# Driver code  
n = 4
print(multiplyBySeven(n)) 
  