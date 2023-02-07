class Solution {
    
    private int dfs(int[][]grid, int i, int j, int sum) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return sum;
        
        sum = sum + grid[i][j];
        int ff = grid[i][j];
        grid[i][j] = 0;
        
        int x = dfs(grid, i+1, j, sum);
        int y = dfs(grid, i, j+1, sum);
        int z = dfs(grid, i-1, j, sum);
        int w = dfs(grid, i, j-1, sum);
    
        grid[i][j] = ff;
        
	// way better than using ---> Collections.max(Array.asList(x, y, w, z);   (5% faster)
        return Math.max(Math.max(Math.max(x, y), z), w); (84% faster)
    }
    
    public int getMaximumGold(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                ans = Math.max(ans, dfs(grid, i, j, 0));
            }
        }
        
        return ans;
    }
}