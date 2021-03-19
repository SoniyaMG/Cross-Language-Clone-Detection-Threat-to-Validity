n = int(input())

games = input().split()
score = []
for i in range(n):
    if games[i] == 'X':
        score.pop()
    elif games[i] == 'Y':
        score.append(int(2 * score[-1]))
    elif games[i] == '+':
        score.append(int(score[-1] + score[-2]))
    else:
        score.append(int(games[i]))

print(sum(score))
