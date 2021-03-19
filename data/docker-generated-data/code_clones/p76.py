# cook your dish here
import sys

t = int(sys.stdin.readline())


def sol(a, b):
    sum1 = 0
    sum2 = 0
    for j in range(len(a[0])):
        if abs(ord(a[0][j]) - ord(a[1][j])) > b:
            return 'LOSE'
        else:
            sum1 += ord(a[0][j])
            sum2 += ord(a[1][j])
    if sum1 == sum2:
        return 'WIN'
    else:
        return 'LOSE'


for i in range(t):
    l = sys.stdin.readline().strip().split(' ')
    t = int(sys.stdin.readline())
    print(sol(l, t))
