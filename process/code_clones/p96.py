T=int(input())
for i in range(T):
    N=int(input())
    s=0
    d=0
    out="Try again"
    while(N>0):
        d+=1
        s+=N%10
        N=N//10
    if(s%d==0):
        out="Good Work"
    print(out)