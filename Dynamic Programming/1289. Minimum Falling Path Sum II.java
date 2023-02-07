class Solution {
    int[][] dp;
    private int solve(int[][] grid, int i, int j) {
        if(i>=grid.length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int ans = Integer.MAX_VALUE;
        for(int k=0; k<grid.length; k++) {
            if(k==j) continue;
            ans = Math.min(ans, grid[i][j] + solve(grid, i+1, k));
        }
        return dp[i][j] = ans;
    }
    
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if(n==1 && m==1) return grid[0][0];
        
        dp = new int[n+1][m+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<m; i++) ans = Math.min(ans, solve(grid, 0, i));
        return ans;
    }
}