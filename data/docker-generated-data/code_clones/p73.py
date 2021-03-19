# cook your dish here
L=[]
first=list(map(int,input().split()))
second=list(map(int,input().split()))
third=list(map(int,input().split()))
fourth=list(map(int,input().split()))
fifth=list(map(int,input().split()))
sixth=list(map(int,input().split()))
L.append(first)
L.append(second)
L.append(third)
L.append(fourth)
L.append(fifth)
L.append(sixth)
S=[]
if L[0][0]==1 or L[5][5]==1:
    print("no")
    exit()
new=[]
maxi=0
for i in range(0,len(L)):
    n=[]
    for j in range(0,len(L[i])):
        if L[i][j]==0:
            if j>=maxi:
                maxi=j
            else:
                n.append(j)
                continue
            n.append(maxi)
        else:
            if j>=maxi: 
                break 
            else:
                continue
    new.append(n)
q=[]
y=True
for i in range(0,len(new)):
    s=set(new[i])
    q.append(s)
for i in range(0,len(q)-1):
    if q[i].isdisjoint(q[i+1])==True:
        y=False
        break
if y==True:
    print("Yes")
else:
    print("No")
        
            