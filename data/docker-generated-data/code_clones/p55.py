def findSum(arr,  n):
    # sort all elements of array
    arr.sort()
  
    sum = arr[0]
    for i in range(0,n-1):
        if (arr[i] != arr[i+1]):
            sum = sum + arr[i+1]
     
    return sum
  
# Driver code
def main():
    arr= [1, 2, 3, 1, 1, 4, 5, 6]
    n = len(arr)
    print(findSum(arr, n))
 
if __name__ == '__main__':
    main()