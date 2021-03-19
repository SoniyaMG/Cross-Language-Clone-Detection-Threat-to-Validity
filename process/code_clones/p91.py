def calc(N):
  if N < 6:
    return 0
  else:
    N -= 2
    N //= 2
    return N * N // 2


import sys
inp = ''.join(sys.stdin.readlines()).split()[::-1]
    
for tc in range(int(inp.pop())):
  N = int(inp.pop())
  print(calc(N) % (10**9 + 7))