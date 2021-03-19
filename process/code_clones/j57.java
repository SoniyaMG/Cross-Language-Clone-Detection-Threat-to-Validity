class GFG{
 
// Function to get minimum number of 
// elements to be deleted from array
// to make array elements equal
static int minDelete(int arr[], int n)
{
     
    // Create an hash map and store 
    // frequencies of all array elements
    // in it using element as key and
    // frequency as value
    HashMap<Integer, Integer> freq = new HashMap<>();
    for(int i = 0; i < n; i++)
        freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
 
    // Find maximum frequency among all frequencies.
    int max_freq = Integer.MIN_VALUE;
    for(Map.Entry<Integer, 
                  Integer> entry : freq.entrySet())
        max_freq = Math.max(max_freq, 
                            entry.getValue());
 
    // To minimize delete operations, 
    // we remove all elements but the
    // most frequent element.
    return n - max_freq ;
}
 
// Driver code
public static void main(String[] args)
{
    int arr[] = { 4, 3, 4, 4, 2, 4 };
    int n = arr.length;
         System.out.print(minDelete(arr, n));
}
}