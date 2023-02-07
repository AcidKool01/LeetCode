class Solution {
    
    Queue<int[]> q= new LinkedList<>();
    
    public void makeIslands(int i, int j, int[][] grid) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==2 || grid[i][j]==0) {
            return;
        }
        
        grid[i][j] = 2;
        q.offer(new int[]{i, j});
        
        makeIslands(i+1, j, grid);
        makeIslands(i, j+1, grid);
        makeIslands(i-1, j, grid);
        makeIslands(i, j-1, grid);
    }
    
    public int connectBridge(int[][] grid) {
        int[][] trav= {{-1,0},{0,1},{1,0},{0,-1}};
        int level= 0;
        
        while(!q.isEmpty())
        {
            int size= q.size();
            while(size-- > 0)
            {
                int []temp= q.poll();
                for(int []dirc: trav) {
                    int i= temp[0]+ dirc[0];
                    int j= temp[1]+ dirc[1];
                    
                    if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 2) continue;
                    
                    if(grid[i][j] == 1) {
                        return level;     
                    } else {
                        grid[i][j]= 2;
                        q.offer(new int[]{i, j});
                    }
                }
            }
            level+= 1;
        }
        
        return -1;
    }
    
    public int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int flag = 0;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(grid[i][j]==1) {
                    makeIslands(i, j, grid);
                    flag=1;
                    break;
                }
            }
            
            if(flag==1) break;
        }
        
        int res = connectBridge(grid);
        
        return res;
    }
}