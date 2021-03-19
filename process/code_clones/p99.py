# cook your dish here
import sys
from collections import defaultdict,deque
import math



INF = float('inf')
MOD = 10**9+7;
# MOD = 998244353;
read = lambda: [int(s) for s in sys.stdin.readline().split()]



_ = 1
# _ = int(input())
while _:
    n,k = read()
    
    arr = read()   

    res = []
    f = 0
    for i in range(0,n-k,k):
        # print(i,f)
        if f==0:
            res.append(arr[i])
            f=1
        else:

            res.append(arr[i+k-1])
            f=0
    



    if f==0:

        for i in range(n-k,n):
            res.append(arr[i])
    
    else:
        for i in range(n-1,n-k-1,-1):
            res.append(arr[i])
    

    print(*res)

    _-=1


# 8 2
# 1 2 3 2 3 4 5 4


