# cook your dish here
n=int(input())
while(n!=0):
    t=input()
    k=list(t)
    s1=0
    s2=0
    x,y=map(int,input().split())
    for i in range(len(k)):
        if(i%2==0):
            s1+=int(k[i])*x
        else:
            s2+=int(k[i])*y
    v=s1+s2
    if(v<=9):
        print(v)
    else:
        while(v>9):
            x=list(str(v))
            b=[int(i) for i in x]
            v=sum(b)
        print(v)
    n=n-1