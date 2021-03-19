# cook your dish here
import math
from collections import Counter
t=int(input())
for i in range(t):
    l=[]
    n,b=list(map(int,input().split()))
    for i in range(n):
        x,y=list(map(int,input().split()))
        d=math.floor(math.sqrt(pow(x,2)+pow(y,2)))
        l.append(d)
    #print(l)
    li=Counter(l)
    sum1=0
    count=0
    for each in li.keys():
        if li[each]>=3:
            sum1+=b
            count+=1
    print(sum1//count)
    
        
    