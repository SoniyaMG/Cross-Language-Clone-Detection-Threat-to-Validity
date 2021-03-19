n = int(raw_input())
nums = raw_input()
numbs = nums.split()

sum = 0
for i in range(n):
    sum += int(numbs[i])
    
print sum