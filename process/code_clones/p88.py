# cook your dish here
from itertools import permutations

def main():
    t = int(input().strip())
    while t > 0:
        n = int(input().strip())
        inp_str = input().strip()
        inp = []
        for x in inp_str:
            if x not in inp:
                inp.append(x)
        inp = sorted(inp)
        inp_str = "".join(inp)
        comb = list(permutations(inp_str))
        comb = ["".join(x) for x in comb]
        comb_str = " ".join(comb)
        print(len(comb))
        print(comb_str)
        t = t - 1
        
main()