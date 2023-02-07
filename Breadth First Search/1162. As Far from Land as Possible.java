class Solution {
    public int maxDistance(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int max=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) queue.add(new Pair<Integer, Integer>(i,j));
            }
        }
        
        if(queue.size()==0 || queue.size()==m*n) return -1;
    
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Pair<Integer, Integer> point = queue.poll();
                for(int[] dir : dirs) {
                    int x = point.getKey() + dir[0];
                    int y = point.getValue() + dir[1];
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==0){
                        grid[x][y]=1;
                        queue.offer(new Pair<Integer, Integer>(x, y));
                    }
                }
            }
            max++;
        }
        return max-1;
    }
}