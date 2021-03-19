class GFG { 
      
    static int multiplyBySeven(int n) 
    {  
        /* Note the inner bracket here.  
        This is needed because precedence 
        of '-' operator is higher  
        than '<<' */
        return ((n << 3) - n); 
    } 
      
    // Driver code 
    public static void main (String arg[])  
    { 
        int n = 4; 
          
        System.out.println(multiplyBySeven(n)); 
    } 
} 