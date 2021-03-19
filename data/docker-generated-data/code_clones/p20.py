def moveZerosToEnd (arr, n): 
  
    # Count of non-zero elements 
    count = 0; 
  
    # Traverse the array. If arr[i] is non-zero, then 
    # swap the element at index 'count' with the 
    # element at index 'i' 
    for i in range(0, n): 
        if (arr[i] != 0): 
            arr[count], arr[i] = arr[i], arr[count] 
            count+=1
  
  
# function to print the array elements 
def printArray(arr, n): 
  
    for i in range(0, n): 
        print(arr[i],end=" ") 
  
  
# Driver program to test above 
arr = [ 0, 1, 9, 8, 4, 0, 0, 2, 
    7, 0, 6, 0, 9 ] 
n = len(arr) 
  
print("Original array:", end=" ") 
printArray(arr, n) 
  
moveZerosToEnd(arr, n) 
  
print("\nModified array: ", end=" ") 
printArray(arr, n) 