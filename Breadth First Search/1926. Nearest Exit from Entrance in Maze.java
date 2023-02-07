
// give below a read ;)
// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/discuss/1329638/python-easy-dfs-memoization-bfs

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length, m = maze[0].length, steps=0;
        Queue<int[]> q = new LinkedList();
        boolean[][] visited = new boolean[n][m];
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        q.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        
        while(!q.isEmpty()) {
            int qSize = q.size();
            steps++;
            for (int i=0; i<qSize; i++) {
                int[] curr = q.poll();
                
                for(int[] dir: dirs ) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];
                    
                    if(x<0 || x>=n || y<0 || y>=m || maze[x][y]=='+' || visited[x][y]==true) continue;
                    if(x==0 || x==n-1 || y==0 || y==m-1) return steps;
                    
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }             
            }
        }
        
        return -1;
    }
}