#dt = {} for i in x: dt[i] = dt.get(i,0)+1
import sys;input = sys.stdin.readline
inp,ip = lambda :int(input()),lambda :[int(w) for w in input().split()]

n = inp()
x = ip()
x.sort()
ans = x[-2:]
x.pop(-1)
x.pop(-1)
while x:
    ans = [x.pop(-1)] + ans[-1:] + ans[:-1]
print(*ans)
    
    