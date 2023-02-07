
// 8ms ---> 3ms : For Same Solution, Just Leetcode Things xD

class Solution {
    
    public void dfs (int i, int j, int[][] grid) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=1) {
            return;
        }
        
        grid[i][j] = -1;
        
        dfs(i+1, j, grid);
        dfs(i, j+1, grid);
        dfs(i-1, j, grid);
        dfs(i, j-1, grid);      
    }
    
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int countOne = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if((i==0 || i==n-1 || j==0 || j==m-1) && grid[i][j]==1) {
                    dfs(i, j, grid);
                }
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(grid[i][j]==1) {
                    countOne++;
                }
            }
        }
        
        return countOne;
    }
}