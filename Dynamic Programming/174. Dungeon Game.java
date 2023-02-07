class Solution {
    
    int[][] dp;
    
    public int solve(int n, int m, int[][] grid) {
        if(n>=grid.length || m>=grid[0].length) {
            return Integer.MAX_VALUE;
        } else if(n==grid.length-1&& m==grid[0].length-1) {
            return Math.max(1, 1-grid[n][m]);
        } else if(dp[n][m] != Integer.MAX_VALUE) {
            return dp[n][m];
        }
        
        int x = solve(n+1, m, grid);
        int y = solve(n, m+1, grid);
        
        int possibleAns = Math.min(x, y) - grid[n][m];
        return dp[n][m] =  Math.max(1, possibleAns);
    }
    
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        dp = new int[n+1][m+1];
        for(int[] rows: dp) Arrays.fill(rows, Integer.MAX_VALUE);
        return solve(0, 0, dungeon);
    }
}