import io,sys,os
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline

def printArr(arr):
	sys.stdout.write(" ".join(map(str,arr)) + "\n")



def feature1(arr,lostTime,k):
    lostTime.sort(key=lambda key:key[0])
    n=len(arr)
    q = len(lostTime)
    for i in range(q):
        l,r = lostTime[i][0],lostTime[i][1]
        lost = sum(arr[l-1:r])
        used,bandwidth = 0,0
        if i+1<q:
            l1,r1 =lostTime[i+1][0],lostTime[i+1][1]
            used=sum(arr[r:l1-1])
            bandwidth = (l1-r-1) * k
        else:
            used = sum(arr[r:])
            bandwidth = (n-r) * k


        if not bandwidth>=used+lost:
            return False
    return True

def feature2(arr,lostTime,k):
    lostTime.sort(key=lambda key:key[0])
    n=len(arr)
    q = len(lostTime)
    helper = [0]*n
    lost=list()
    for i in range(q):
        l,r = lostTime[i][0],lostTime[i][1]
        lost.append(sum(arr[l-1:r]))
        if i+1<q:
            l1,r1 =lostTime[i+1][0],lostTime[i+1][1]
            if l1>r+1:
                used = sum(arr[r:l1-1])
                bandwidth = (l1-r-1)*k
                for los in lost:
                    if not bandwidth>=used+los:
                        return False
                lost=list()
            else:
                continue
        else:
            used = sum(arr[r:])
            bandwidth = (n-r) * k
            for los in lost:
                if not bandwidth>=used+los:
                    return False
            lost=list()
    if lost:
        return False
    return True



t=int(input().decode())
while t>0:
	s=input().decode().strip().split()
	n,k,f=int(s[0]),int(s[1]),int(s[2])
	arr=[int(i) for i in input().decode().strip().split()]
	q = int(input().decode())
	lostTime = list()
	for i in range(q):
		s=input().decode().strip().split()
		lostTime.append((int(s[0]),int(s[1])))
	answer=True
	if f==1:
		answer=feature1(arr,lostTime,k)
	if f==2:
		answer=feature2(arr,lostTime,k)
	if answer:
		sys.stdout.write(str('YES')+'\n')
	else:
		sys.stdout.write(str('NO')+'\n')
	t-=1
