def smallestGreater(arr, n) :
    for i in range(0, n) :
 
        # Find the closest greater element 
        # for arr[j] in the entire array.
        diff = 1000; 
        closest = -1;
        for j in range(0, n) :
            if ( arr[i] < arr[j] and
                  arr[j] - arr[i] < diff) :
                diff = arr[j] - arr[i];
                closest = j;     
         
        # Check if arr[i] is largest
        if (closest == -1) :
            print ("_ ", end = "");
        else :
            print ("{} ".format(arr[closest]),
                                    end = "");
 
# Driver code
ar = [6, 3, 9, 8, 10, 2, 1, 15, 7];
n = len(ar) ;
smallestGreater(ar, n);