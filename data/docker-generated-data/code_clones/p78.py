MAX = 99999999999999999999999999999999999999999999

for tc in range(int(input())):
	M = int(input())
	N = int(input())
	A = [list(map(int, input().split())) for i in range(N)]
	A = sorted(A, key=lambda x: x[0])

	p2 = 0
	s = 0
	ans = MAX
	for p1 in range(N):
		while p2 < N and s < M:
			s += A[p2][1]
			p2 += 1
		if s >= M:
			ans = min(ans, A[p2 - 1][0] - A[p1][0])
		else:
			break
		s -= A[p1][1]
	print (ans)