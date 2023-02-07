class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int clickRow = click[0];
        int clickCol = click[1];
        
        if(board[clickRow][clickCol]=='M') {
            board[clickRow][clickCol] = 'X';
            return board;
        }
        
        if(isAdjacentToMine(board,clickRow,clickCol)) {
            return board;
        } else {
            reveal(board,clickRow,clickCol);
        }
        
        return board;
    }
    
    private void reveal(char[][] board, int row, int col) {
        if(row<0 || row>=board.length) { return; }
        if(col<0 || col>=board[0].length) { return; }
        
        if(board[row][col] == 'B'){
            return;
        }
        
        if(isAdjacentToMine(board,row,col)){
            return;
        }
        
        board[row][col] = 'B';
        
        reveal(board, row+1, col);
        reveal(board, row-1, col);
        reveal(board, row+1, col+1);
        reveal(board, row+1, col-1);
        reveal(board, row-1, col+1);
        reveal(board, row-1, col-1);
        reveal(board, row, col+1);
        reveal(board, row, col-1);  
        
    }
    
    private boolean isAdjacentToMine(char[][] board,int row, int col){
        int mineCount = 0;
        if(isMine(board, row+1, col)){
            mineCount++;
        }
        if(isMine(board, row-1, col)){
            mineCount++;
        }
        if(isMine(board, row+1, col-1)){
            mineCount++;
        }
        if(isMine(board, row+1, col+1)){
            mineCount++;
        }
        if(isMine(board, row-1, col+1)){
            mineCount++;
        }
        if(isMine(board, row-1, col-1)){
            mineCount++;
        }
        if(isMine(board, row, col+1)){
            mineCount++;
        }
        if(isMine(board, row, col-1)){
            mineCount++;
        }
        
        if(mineCount > 0){
            char c = Character.forDigit(mineCount, 10);
            board[row][col] = c;
            return true;
        }
        return false;
    }
    
    private boolean isMine(char[][] board, int row, int col){
        if(row<0 || row>=board.length){return false;}
        if(col<0 || col>=board[0].length){return false;}
        if(board[row][col] == 'M'){
            return true;
        }
        
        return false;
    }
}