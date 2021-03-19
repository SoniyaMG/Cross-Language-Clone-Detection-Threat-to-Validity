# cook your dish here
for _ in range(int(input())):
    n, count, M = int(input()), 0, 1000000007
    ls = list(map(int, input().split()))
    for i in ls: count += 1 if i % 5 == 0 else 0
    print((2**(n - count) % M) * (2**(count) % M - 1) % M)