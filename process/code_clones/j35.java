class GFG
{
     
    // returns maximum in
    // arr[] of size n
    static int largest(int []arr,   
                       int n)
    {
        Arrays.sort(arr);
        return arr[n - 1];
    }
 
    // Driver code
    static public void main (String[] args)
    {
        int []arr = {10, 324, 45, 
                     90, 9808};
        int n = arr.length;
        System.out.println(largest(arr, n));
    }
}