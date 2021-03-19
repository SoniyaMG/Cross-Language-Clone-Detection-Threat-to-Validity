for _ in range(int(input())):
    n, d = map(int, input().split())
    arr = list(map(int, input().split()))
    res = [0 for i in range(n)]
    res[-1] = d - (d % arr[-1])
    for i in range(n - 2, -1, -1):
        res[i] = res[i + 1] - (res[i + 1] % arr[i])
    print(res[0])