class Solution {
    private long mod = (long)(1e9+7);
    private long[][][] dp;
    
    private long solve(int n, int m, int i, int j, int k) {
        if(k==-1) return 0;
        if(i<0 || i>=n || j<0 || j>=m) return 1;
        if(dp[i][j][k] != -1) return dp[i][j][k]%mod; 
        
        long a = solve(n, m, i+1, j, k-1)%mod;
        long b = solve(n, m, i, j+1, k-1)%mod;
        long c = solve(n, m, i-1, j, k-1)%mod;
        long d = solve(n, m, i, j-1, k-1)%mod;
        
        return dp[i][j][k] = (a+b+c+d)%mod;
    }
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new long[m+1][n+1][maxMove+1];
        for(int i=0; i<m; i++) { for (int j=0; j<n; j++) { long[] row = dp[i][j]; Arrays.fill(row, -1); } }
        return (int)solve(m, n, startRow, startColumn, maxMove);
    }
}