def areDisjoint(set1, set2, m, n): 
    # Take every element of set1[] and search it in set2 
    for i in range(0, m): 
        for j in range(0, n): 
            if (set1[i] == set2[j]): 
                return False
  
    # If no element of set1 is present in set2 
    return True
  
  
# Driver program 
set1 = [12, 34, 11, 9, 3] 
set2 = [7, 2, 1, 5] 
m = len(set1) 
n = len(set2) 
print("yes") if areDisjoint(set1, set2, m, n) else(" No") 
  