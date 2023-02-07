class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        
        int[] dx={1,1,1,-1,-1,-1,0,0};
        int[] dy={1,0,-1,1,-1,0,1,-1};
        int n = grid.length, m = grid[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        int[][] visited = new int[n][m];
        int count=0;
        
        q.add(new Pair<Integer, Integer>(0, 0));
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for (int k=0; k<size; k++) {
                Pair<Integer, Integer> curr = q.poll();
                if(curr.getKey()==n-1 && curr.getValue()==m-1) {
                    return count+1;
                }
                
                for (int i=0; i<8; i++) {
                    int x = curr.getKey() + dx[i];
                    int y = curr.getValue() + dy[i];

                    if(x>=0 && x<=n-1 && y>=0 && y<=m-1 && grid[x][y]==0 && visited[x][y]==0) {
                        visited[x][y] = 1;
                        q.add(new Pair<Integer, Integer>(x, y));
                    }
                }
            }
            count++;
        }
        
        return -1;
    }
}