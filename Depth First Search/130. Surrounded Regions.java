class Solution {
    
    public void dfs (int n, int m, char[][] grid) {
        if(n<0 || n>=grid.length || m<0 || m>=grid[0].length || grid[n][m]!='O') {
            return;
        }
        
        if(grid[n][m]=='O') grid[n][m] = 'F';
        
        dfs(n+1, m, grid);
        dfs(n, m+1, grid);
        dfs(n-1, m, grid);
        dfs(n, m-1, grid);

    }
    
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        boolean flag = false;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(board[i][j]=='X') {
                    flag = true;
                }
            }
        }     
        if(!flag) return;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if((i==0 || i==n-1 || j==0 || j==m-1) && board[i][j]=='O') {
                    dfs(i, j, board);
                }
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='F') board[i][j]='O';
            }
        }
    }
}