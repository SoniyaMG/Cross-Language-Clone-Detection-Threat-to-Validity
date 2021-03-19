try:
    import sys
    # input=__import__('sys').stdin.readline
    # from math import ceil
     # For getting input f  rom input.txt file 
    # sys.stdin = open('input.txt', 'r')  
    from math import sqrt
    # Printing the Output to output.txt file 
    # sys.stdout = open('output.txt', 'w')
    def solve(x,y,z):
        dis= sqrt( ((x[0]-y[0])**2) + ((x[1]-y[1])**2) )
        # print(dis)
        if dis<x[2]+y[2]:
            d = sqrt( (x[2]**2)+(y[2]**2) )
            mx=(x[0]+y[0])//2
            my=(x[1]+y[1])//2
            
            if mx==z[0] and my==z[1] and 2*z[2]==d==dis:
                return True
            
    t=int(input())
    for _ in range(t):
        l=[]
        n=int(input())
        for i in range(n):
            l.append([int(x) for x in input().split()])
        res=0
        for i in range(n-2):
            for j in range(i+1,n-1):
                for k in range(j+1,n):
                    flag1=flag2=flag3=False
                    flag1=solve(l[i],l[j],l[k])
                    flag2=solve(l[i],l[k],l[j])
                    flag3=solve(l[j],l[k],l[i])
                    if flag1 or flag2 or flag3:
                        res+=1
        print(res)
            
except EOFError:
    pass