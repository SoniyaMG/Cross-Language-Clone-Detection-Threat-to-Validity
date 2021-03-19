# cook your dish here
t=int(input());
for i in range(t):
    n=int(input());
    c=0;
    while(n!=0):
        r=n%10;
        if r==7:
            c=c+1;
        n=n//10;
    if c>0:
        print("True");
    else:
        print('False');
        