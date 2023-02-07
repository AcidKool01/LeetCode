class Solution {
    int dp[][];
    public int solve (int n, int m, int[][] grid) {
        if(m<0 || m>=grid[0].length || n<0 || n>=grid.length) {
            return Integer.MAX_VALUE;
        } else if(n==grid.length-1) {
            return grid[n][m];
        } else if(dp[n][m] != Integer.MIN_VALUE) {
            return dp[n][m];
        } 
        
        int x = solve(n+1, m-1, grid);
        int y = solve(n+1, m, grid);
        int z = solve(n+1, m+1, grid);
        
        return dp[n][m] = grid[n][m] + Math.min(x, Math.min(y, z));                 
    }
    
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int res = Integer.MAX_VALUE;
        dp = new int[n][m];
        for(int[] rows: dp) Arrays.fill(rows, Integer.MIN_VALUE);
        
        for(int i=0; i<matrix[0].length; i++) {
            res = Math.min(res, solve(0, i, matrix));
        }
        return res;
    }
}