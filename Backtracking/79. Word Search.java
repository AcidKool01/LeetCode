class Solution {
    
    private boolean dfs (char[][] board, int i, int j, String word, int x) {
        if(x==word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        if(board[i][j] != word.charAt(x)) return false;
        
        board[i][j] = '*';
        boolean ans = dfs(board, i+1, j, word, x+1) || dfs(board, i-1, j, word, x+1) || dfs(board, i, j+1, word, x+1) || dfs(board, i, j-1, word, x+1);
        board[i][j] = word.charAt(x);
        
        return ans;
    }
 
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(dfs(board, i, j, word, 0)) return true;
                else continue;
            }
        }
        
        return false;
    }
}