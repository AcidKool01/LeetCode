class Solution {

    private long ans = 0;
    private long temp = 0;
    private long mod = (long)1e9+7;
    private long[][] dp;
    
    private long dfs (int i, int j, int n, int m, int k, int[][] matrix) {
        if(i<0 || i>=n || j<0 || j>=m || matrix[i][j] <= k) { return 0; }
        if(dp[i][j]!=-1) return dp[i][j];

        long a = (dfs(i+1, j, n, m, matrix[i][j], matrix))%mod;
        long b = (dfs(i, j+1, n, m, matrix[i][j], matrix))%mod;
        long c = (dfs(i-1, j, n, m, matrix[i][j], matrix))%mod;
        long d = (dfs(i, j-1, n, m, matrix[i][j], matrix))%mod;
        
        return dp[i][j] = (a+b+c+d+1)%mod;
    }
    
    
    public int countPaths(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        dp = new long[n+1][m+1];
        for(long[] row: dp) Arrays.fill(row, -1);
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                temp = dfs(i, j, n, m, -1, matrix);
                ans = (ans%mod + temp%mod)%mod;
            }
        }
        
        return (int)ans;
    }
}