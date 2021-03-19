def pattern(n):
	a = []
	l ,c = 0, 1
	for i in range(n, 1, -1):
		s = ""
		s += "| "*c
		s+= (str(i) + " ")*(i*2 - 3)
		s += "| "*c
		a.append(s)
		c += 1
	
	for i in a:
		print(i)
	
	c -= 1
	print("| " * c, end = '')
	print("1 ", end = '')
	print("| " * c)
	
	for i in reversed(a):
		print(i)

for _ in range(int(input())):
	pattern(int(input()))