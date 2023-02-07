class Solution {
    private int ans = 0;
    private int[][] dp;
    
    private int solve (int[][] grid, int i, int j) {
        if(i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return -1;
        if(dp[i][j] != -1) return dp[i][j];
        if(i+1>=grid.length || grid[i+1][j]==0) return 0;
        return dp[i][j] = 1 + Math.min(solve(grid, i+1, j-1), solve(grid, i+1, j+1));
    }
    
    public int countPyramids(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        dp = new int[n+1][m+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        int res = 0;
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(grid[i][j]==1)
                res = res + solve(grid, i, j);
            }
        }
        
        int[][] rev = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) rev[n - i - 1][j] = grid[i][j];
        }
        
        for(int[] row: dp) Arrays.fill(row, -1);
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(rev[i][j]==1)
                res = res + solve(rev, i, j);
            }
        }

        return res;
    }
}