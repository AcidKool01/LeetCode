
// 100% faster be********

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count=-1;
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==2) {
                    q.add(new Pair<Integer, Integer>(i, j));
                    grid[i][j] = 3;
                }
            }
        }
        
        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i=0; i<qSize; i++) {
                int x = q.peek().getKey();
                int y = q.peek().getValue();
                q.remove();
                
                if(x>=0 && x<n && y+1>=0 && y+1<m && grid[x][y+1]==1) {
                    q.add(new Pair<Integer, Integer>(x, y+1));
                    grid[x][y+1] = 3;
                }
                if(x+1>=0 && x+1<n && y>=0 && y<m && grid[x+1][y]==1) {
                    q.add(new Pair<Integer, Integer>(x+1, y));
                    grid[x+1][y] = 3;
                }
                if(x-1>=0 && x-1<n && y>=0 && y<m && grid[x-1][y]==1) {
                    q.add(new Pair<Integer, Integer>(x-1, y));
                    grid[x-1][y] = 3;
                }
                if(x>=0 && x<n && y-1>=0 && y-1<m && grid[x][y-1]==1) {
                    q.add(new Pair<Integer, Integer>(x, y-1));
                    grid[x][y-1] = 3;
                }
            }
            count++;
        } 
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(grid[i][j]==1) {
                    return -1;
                }
            }
        }
        
        return count==-1 ? 0 : count;
    }
}