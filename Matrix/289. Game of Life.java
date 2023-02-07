// OP SOLUTION

private static final int[][] DIRS = {{-1, -1}, // top-left
 									 {-1, 0},  // top
									 {-1, 1},  // top-right
									 {0, -1},  // left
									 {0, 1},   // right
									 {1, -1},  // bottom-left
									 {1, 0},   // bottom
									 {1, 1}};  // bottom-right

public void gameOfLife(int[][] board) {
	var rows = board.length;
	var cols = board[0].length;
	playGame(board, rows, cols);
	updateBoard(board, rows, cols);
}

private void playGame(int[][] board, int rows, int cols) {
	for (var i = 0; i < rows; i++)
		for (var j = 0; j < cols; j++) {
			var alive = aliveNeighbors(board, rows, cols, i, j);
			// Dead cell with 3 live neighbors becomes alive
			if (board[i][j] == 0 && alive == 3)
				board[i][j] = 2;
			// Live cell with 2 or 3 live neighbors lives on
			else if (board[i][j] == 1 && (alive == 2 || alive == 3))
				board[i][j] = 3;
		}
}

private int aliveNeighbors(int[][] board, int rows, int cols, int i, int j) {
	var alive = 0;
	for (var dir : DIRS) {
		var neighborX = i + dir[0];
		var neighborY = j + dir[1];
		if (isOutOfBounds(rows, cols, neighborX, neighborY))
			continue;
		alive += board[neighborX][neighborY] & 1;
	}
	return alive;
}

private boolean isOutOfBounds(int rows, int cols, int x, int y) {
	return x < 0 || x >= rows || y < 0 || y >= cols;
}

private void updateBoard(int[][] board, int rows, int cols) {
	for (var i = 0; i < rows; i++)
		for (var j = 0; j < cols; j++)
			board[i][j] >>= 1;
}


// AWFUL SOLUTION

class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        int[][] temp = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                temp[i][j] = board[i][j];
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int countZero = 0, countOne = 0;
                if(i+1<n) {
                    if(temp[i+1][j]==1) countOne++;
                    else countZero++;
                }
                if(j+1<m) {
                    if(temp[i][j+1]==1) countOne++;
                    else countZero++;
                }
                if(i-1>=0) {
                    if(temp[i-1][j]==1) countOne++;
                    else countZero++;
                }
                if(j-1>=0) {
                    if(temp[i][j-1]==1) countOne++;
                    else countZero++;
                }
                if(i+1<n && j+1<m) {
                    if(temp[i+1][j+1]==1) countOne++;
                    else countZero++;
                }
                if(i+1<n && j-1>=0) {
                    if(temp[i+1][j-1]==1) countOne++;
                    else countZero++;
                }
                if(i-1>=0 && j-1>=0) {
                    if(temp[i-1][j-1]==1) countOne++;
                    else countZero++;
                }
                if(i-1>=0 && j+1<m) {
                    if(temp[i-1][j+1]==1) countOne++;
                    else countZero++;
                }
                
                if(temp[i][j]==1) {
                    if(countOne<=1) board[i][j] = 0;
                    else if(countOne>3) board[i][j] = 0;
                } else {
                    if(countOne==3) board[i][j] = 1;
                }
            }
        }
    }
}