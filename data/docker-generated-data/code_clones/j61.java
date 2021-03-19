class GFG 
{ 
      
// Returns k-th missing element. It returns -1 if 
// no k is more than number of missing elements. 
static int find(int a[], int b[], int k, int n1, int n2) 
{ 
    // Insert all elements of givens sequence b[]. 
    LinkedHashSet<Integer> s = new LinkedHashSet<>(); 
    for (int i = 0; i < n2; i++) 
        s.add(b[i]); 
  
    // Traverse through increasing sequence and  
    // keep track of count of missing numbers. 
    int missing = 0; 
    for (int i = 0; i < n1; i++)  
    { 
        if(!s.contains(a[i]) )  
            missing++; 
        if (missing == k) 
            return a[i]; 
    } 
  
    return -1; 
} 
  
// Driver code 
public static void main(String[] args)  
{ 
    int a[] = { 0, 2, 4, 6, 8, 10, 12, 14, 15 }; 
    int b[] = { 4, 10, 6, 8, 12 }; 
    int n1 = a.length; 
    int n2 = b.length; 
  
    int k = 3; 
    System.out.println(find(a, b, k, n1, n2)); 
} 
}  