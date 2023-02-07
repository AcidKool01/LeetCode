class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for(int[][] row1: dp) for(int[] row2: row1) Arrays.fill(row2, -1);
        return Math.max(0,cherryCount(grid,0,0,0,grid.length,dp));
    }
    
    public int cherryCount(int[][] grid, int i, int j1, int j2, int n, int[][][] dp){
        int i2 = i + j1-j2;
        
        if(i==n || i2==n || j1==n || j2==n || grid[i][j1]==-1 || grid[i2][j2]==-1) {
            return Integer.MIN_VALUE;
        } else if(i==n-1 && j1==n-1) {
            return grid[i][j1];
        } else if(dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        } else {
            int ans = grid[i][j1];
            if(j1!=j2) ans+= grid[i2][j2];
            
            int a = cherryCount(grid,i,j1+1,j2+1,n,dp);
            int b = cherryCount(grid,i+1,j1,j2+1,n,dp);
            int c = cherryCount(grid,i,j1+1,j2,n,dp);
            int d = cherryCount(grid,i+1,j1,j2,n,dp);
            
            ans +=Math.max(Math.max(a, b), Math.max(c, d));
            return dp[i][j1][j2]=ans;
        }
    }
}