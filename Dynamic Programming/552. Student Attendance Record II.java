class Solution {
    private int[][][] dp;
    private long mod = (long)1e9+7;
    private long solve(int n, int a, int l) {
        if(a<0 || l<0) return 0;
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n][a][l] != -1) return dp[n][a][l];
        
        long ans = 0;
        ans = (solve(n-1, a, 2)%mod + solve(n-1, a-1, 2)%mod + solve(n-1, a, l-1)%mod)%mod;
        return dp[n][a][l] = (int)(ans%mod);
    }
    
    public int checkRecord(int n) {
        dp = new int[n+1][2][3];
        for(int[][] d1 : dp) for(int[] d2 : d1) Arrays.fill(d2, -1);
        return (int)solve(n, 1, 2);
    }
}