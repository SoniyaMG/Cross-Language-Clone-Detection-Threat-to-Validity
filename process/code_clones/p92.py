# cook your dish here
try:
    n=int(input())
    l=list(map(int,input().split()))
    l1=[0]*(max(l)+1)
    
    
    for i in range(0,len(l)):
        l1[l[i]]+=1
        
    
    
    maj=len(l)/2
    ans=-1
    for i in range(0,len(l1)):
        if(l1[i]>=maj):
            ans=(i)
            break
            
    print(ans)
    
except:
    pass