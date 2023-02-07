class Solution {
    
    public int solve (int n, int m, int[][] grid) {
        if(n<0 || n>grid.length-1 || m<0 || m>grid[0].length-1 || grid[n][m]==0) {
            return 0;
        }
        
        grid[n][m] = 0;
        return 1+solve(n+1, m, grid)+solve(n-1, m, grid)+solve(n, m+1,grid)+solve(n, m-1, grid);
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                maxArea = Math.max(maxArea, solve(i, j, grid));
            }
        }
        
        return maxArea;
    }
}