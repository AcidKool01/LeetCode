class Solution {
    private int ans =0;
    private static final int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] {0, 0, 0});
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0], j = curr[1];
            int currDist = curr[2];
            if(i==m-1 && j==n-1) break;
            for (int[] dir: dirs) {
                int x = i + dir[0], y = j + dir[1];
                if(x<0 || y<0 || x>=m || y>=n) continue;
                int newDist = Math.max(currDist, Math.abs(heights[i][j] - heights[x][y]));
                if(newDist < dist[x][y]) {
                    dist[x][y] = newDist;
                    pq.offer(new int[]{x, y, dist[x][y]});
                }
            }
        }
        return dist[m-1][n-1];
    }
}