class Solution {
public:
    
    bool isSafe(int row, int col, vector<vector<int>> &grid) {
        for(int i=0; i<col; i++) {
            if(grid[row][i]) {
                return false;
            }
        }
        
        for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if(grid[i][j]) {
                return false;
            }
        }
        
        for(int i=row, j=col; i<grid.size() && j>=0; i++, j--) {
            if(grid[i][j]) {
                return false;
            }
        }
        
        return true;
    }
    
    bool mcQueen (int col, int n, vector<vector<int>> &grid, vector<vector<string>> &res) {
        if(col==n) {
            string str="";
            vector<string> v;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(grid[i][j]) {
                        str.push_back('Q');
                    } else {
                        str.push_back('.');
                    }
                }
                v.push_back(str);
                str="";
            }
            
            res.push_back(v);
            return true;
        }
        for (int row=0; row<n; row++) {
            if(isSafe(row, col, grid)) {
                grid[row][col] = 1;
                mcQueen(col+1, n, grid, res);
                grid[row][col] = 0;
            }
        }
        return false;
    }
    
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<int>> grid(n, vector<int>(n, 0));
        vector<vector<string>> res;
        mcQueen(0, n, grid, res);
        // sort(res.begin(), res.end());
        return res;
    }
};