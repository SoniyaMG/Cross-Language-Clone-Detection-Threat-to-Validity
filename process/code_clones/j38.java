class GFG 
{
static void smallestGreater(int arr[], 
                            int n)
{
    for (int i = 0; i < n; i++) 
    {
 
        // Find the closest greater
        // element for arr[j] in 
        // the entire array.
        int diff = Integer.MAX_VALUE;
        int closest = -1;
        for (int j = 0; j < n; j++) 
        {
            if (arr[i] < arr[j] && 
                arr[j] - arr[i] < diff)
            {
                diff = arr[j] - arr[i];
                closest = j;         
            }
        }
         
        // Check if arr[i] is largest
        if(closest == -1)
        System.out.print( "_ " );
        else
        System.out.print(arr[closest] + " ");
    }
}
 
// Driver code
public static void main (String[] args) 
{
    int ar[] = {6, 3, 9, 8, 10, 
                2, 1, 15, 7};
    int n = ar.length;
    smallestGreater(ar, n);
}
}