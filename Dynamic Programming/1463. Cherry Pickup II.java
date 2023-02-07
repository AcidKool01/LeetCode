class Solution {
    int[][][] dp;
    private int dfs(int[][] grid, int i, int j1, int j2) {
        if(i<0 || i>=grid.length || j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length || j1 > j2) return 0;
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        int ans = Integer.MIN_VALUE;
        for(int r=-1; r<=1; r++) {
            for(int c=-1; c<=1; c++) {
                if(j1==j2) ans = Math.max(ans, grid[i][j1] + dfs(grid, i+1, j1+r, j2+c));
                else ans = Math.max(ans, grid[i][j1] + grid[i][j2] + dfs(grid, i+1, j1+r, j2+c));
            }
        }
        
        return dp[i][j1][j2] = ans;
    }
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        dp = new int[n+1][m+1][m+1];
        for(int i=0; i<n; i++) { int[][] a = dp[i]; for(int[] b: a) { Arrays.fill(b,-1); } }
        
        return dfs(grid, 0, 0, m-1);
    }
}