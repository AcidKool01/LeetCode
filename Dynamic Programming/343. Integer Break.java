class Solution {
    private int[][] dp;
    private int solve(int n, int i) {
        if(n==0 || i==0) return 1;
        if(dp[n][i] != -1) return dp[n][i];
        
        if(i>n) return dp[n][i] = solve(n, i-1);
        return dp[n][i] = Math.max(i*solve(n-i, i), solve(n, i-1));
    }
    
    public int integerBreak(int n) {
        dp=new int[n+1][n+1];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return solve(n, n-1);
    }
}