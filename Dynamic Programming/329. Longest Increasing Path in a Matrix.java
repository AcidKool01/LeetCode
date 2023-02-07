class Solution {
    private int ans = 0;
    private int temp = 0;
    private int[][] dp;
    
    private int dfs (int i, int j, int n, int m, int k, int[][] matrix) {
        if(i<0 || i>=n || j<0 || j>=m || matrix[i][j] <= k) { return 0; }
        if(dp[i][j]!=-1) return dp[i][j];

        int a = dfs(i+1, j, n, m, matrix[i][j], matrix) +1;
        int b = dfs(i, j+1, n, m, matrix[i][j], matrix) +1;
        int c = dfs(i-1, j, n, m, matrix[i][j], matrix) +1;
        int d = dfs(i, j-1, n, m, matrix[i][j], matrix) +1;
        
        return dp[i][j] = Math.max(Math.max(Math.max(a, b), c), d);
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        dp = new int[n+1][m+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                temp = dfs(i, j, n, m, -1, matrix);
                ans = Math.max(ans, temp);
            }
        }
        
        return ans;
    }
}