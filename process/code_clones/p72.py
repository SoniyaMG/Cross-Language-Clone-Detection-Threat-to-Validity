# cook your dish here 
t=int(input())
for _ in range(t): 
    n=int(input()) 
    a=list(map(int,input().split())) 
    m =0 
    s=0 
    for i in range(n): 
        s+=a[i] 
        m=max(a[i],m)
    if (s-m)>m: 
        print("Yes") 
    else: 
        print("No")
    print("")    