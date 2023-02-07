class Solution {
    private int ans = 0;
    int empty = 1;
    
    private void solve(int[][] grid, int i, int j, int count) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==-1) return;
        if(grid[i][j]==2) {
            // System.out.println(count + "-->" + empty);
            if(count==empty) ans++;
            return;
        }
        
        grid[i][j] = -1;
        
        solve(grid, i+1, j, count+1);
        solve(grid, i, j+1, count+1);
        solve(grid, i-1, j, count+1);
        solve(grid, i, j-1, count+1);
        
        grid[i][j] = 0;
    }
    
    public int uniquePathsIII(int[][] grid) {
        int start = 0, end = 0;
        int n = grid.length, m = grid[0].length;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(grid[i][j]==1) {
                    start = i; end = j;
                } else if(grid[i][j]==0) {
                    empty = empty+1;
                }
            }
        }
        
        solve(grid, start, end, 0);
        return ans;
    }
}