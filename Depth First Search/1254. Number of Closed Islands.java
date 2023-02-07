
// Implement Find No. of Islands using DFS and just return the no. of DFS call.. that's all :)

class Solution {
    boolean flag = true;
    public void dfs (int n, int m, int[][] grid) {
        if(n<0 || n>=grid.length || m<0 || m>=grid[0].length || grid[n][m]==1) {
            return;
        }
        
        if((n==0 || m==0 || n==grid.length-1 || m==grid[0].length-1) && grid[n][m]==0) {
            flag=false;
        }
        
        grid[n][m]=1;
        dfs(n+1, m, grid); 
        dfs(n-1, m, grid);
        dfs(n, m+1, grid);
        dfs(n, m-1, grid);
    }
    
    public int closedIsland(int[][] grid) {
        int ans=0;
        for(int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==0) {
                    dfs(i, j, grid);
                    if(flag) ans++;
                    flag = true;
                }
            }
        }
        return ans;
    }
}