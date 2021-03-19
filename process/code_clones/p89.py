n, m, k = [int(x) for x in input().split()]
l = []
for i in range(n):
    tmp = list([int(x) for x in input().split()])
    l.append(tmp)

c = 0
i = 0
j = 0
for i in range(n):
    for j in range(m):
        if(l[i][j] == 1):

            t = 0
            pi = i
            pj = j
            while(pi < n and pj < m and l[pi][pj] == 1):
                t += 1
                pi += 1
                pj += 1
            if(t >= k):
                c += 1

            t = 0
            pi = i
            pj = j
            while(pi < n and pj > -1 and l[pi][pj] == 1):
                t += 1
                pi += 1
                pj -= 1
            if(t >= k):
                c += 1

            t = 0
            pi = i
            pj = j
            while(pi < n and l[pi][pj] == 1):
                pi += 1
                t += 1
            if(t >= k):
                c += 1

            t = 0
            pi = i
            pj = j
            while(pj < m and l[pi][pj] == 1):
                pj += 1
                t += 1
            if(t >= k):
                c += 1


print(c)