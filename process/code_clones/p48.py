def getAvg(prev_avg, x, n): 
    return ((prev_avg * 
             n + x) / 
            (n + 1)); 
  
# Prints average of  
# a stream of numbers 
def streamAvg(arr, n): 
    avg = 0; 
    for i in range(n): 
        avg = getAvg(avg, arr[i], i); 
        print("Average of ", i + 1, 
              " numbers is ", avg); 
  
# Driver Code 
arr = [10, 20, 30, 
       40, 50, 60]; 
n = len(arr); 
streamAvg(arr, n);