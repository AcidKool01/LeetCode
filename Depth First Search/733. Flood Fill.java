class Solution {
    
    public void dfs (int n, int m, int k, int f, int[][] grid) {
        if(n<0 || n>=grid.length || m<0 || m>=grid[0].length || grid[n][m] != k) {  
            return;
        }
        
        grid[n][m] = f;
        
        dfs(n+1, m, k, f, grid);
        dfs(n-1, m, k, f, grid);
        dfs(n, m+1, k, f, grid);
        dfs(n, m-1, k, f, grid);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;         // leetcode loves trollin' :(
        int k = image[sr][sc];
        dfs(sr, sc, k, newColor, image);
        return image;
    }
}