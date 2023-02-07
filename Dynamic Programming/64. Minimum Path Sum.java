class Solution {
    
    int[][] dp;
    
    public int solve (int n, int m, int[][] grid) {
        
        if(n<0 || m<0) {
            return Integer.MAX_VALUE;
        } else if((n==0 && m==0)) {
            return grid[n][m];
        } else if(dp[n][m] != -1) {
            return dp[n][m];
        } else {
            return dp[n][m] = grid[n][m] + Math.min(solve(n-1, m, grid), solve(n, m-1, grid)); 
        }
        
    }
    
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length+1][grid[0].length+1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return solve(grid.length-1, grid[0].length-1, grid);
    }
}