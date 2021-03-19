n = int(input())
arr = list(map(int, input().strip().split()))
fin = []

S = []
for i in range(n):
	while (len(S) > 0 and S[-1][0] >= arr[i]): 
		S.pop() 
	if (len(S) == 0): 
		fin.append(0)
	else:
		fin.append(S[-1][-1]+1)
	S.append((arr[i], i)) 

print(" ".join(tuple(map(str, fin))))