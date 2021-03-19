# cook your dish here
A= input()
B= input()
C=A.split()
D=B.split()
numA=0
numB=0
if(len(C)==3 and len(D)==3):
    for i in range(3):
        if(((int (C[i]))<(int (D[i]))) and ((int (D[i]))<100)):
            numB+=1
        elif(((int (C[i]))>(int (D[i]))) and ((int (C[i]))<100)):
            numA+=1
print(numA,numB)