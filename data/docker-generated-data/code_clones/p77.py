n, q = map(int, input().split())
a = list(map(int, input().split()))
prev = a[0]
for i in range(1, n):
    cur = a[i] - prev
    prev = a[i]
    a[i] = cur
prev = zero = a[0]
a[0] = 0
for i in range(1, n):
    a[i], prev = a[i] - prev, a[i]
#print(zero, a)
for i in range(q):
    l, r, i = map(int, input().split())
    l -= 1
    r -= 1
    a[l] -= i
    if r < n-1:
        a[r+1] += i
    #print(a)
prev = zero
for i in range(n):
    a[i] = prev + a[i]
    prev = a[i]
print(" ".join([str(ele) for ele in a]))