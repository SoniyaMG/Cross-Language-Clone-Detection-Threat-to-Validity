dp = {}
MOD = 1000000007
def ways(n):
    dp[0]=0
    dp[1]=1
    dp[2]=1
    
    if dp.get(n):
        return dp[n]
    
    for i in range(3,n):
        dp[i]= (dp[i-1]%MOD + dp[i-2]%MOD)%MOD
    
    
if __name__=="__main__":
    for i in range(int(input())):
        n,m = map(int,input().split())
        res = ways(n)
        ans = [0,dp[n-1],1,dp[n-2],1,dp[n-3],2,dp[n-4],3,dp[n-5]]
        for k in range(m):
            print(ans[k],end=' ')
        print()