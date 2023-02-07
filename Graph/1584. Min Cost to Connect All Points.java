class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int i=1; i<n; i++) {
            int dist = Math.abs(points[0][0]-points[i][0]) + Math.abs(points[0][1]-points[i][1]);
            pq.add(new int[]{i, dist});
        }
        
        int len = n-1;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int cost=0;
           
        while(!pq.isEmpty() && len > 0) {
            int[] curr =pq.poll();
            int i = curr[0];
            
            if(!visited[i]) {
                visited[i]=true;
                cost += curr[1];
                len--;
                
                for (int j=0; j<n; j++) {
                    if(i==j || visited[j]) continue;
                    pq.add(new int[]{j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])});
                }
            }
        }
        return cost;
    }
}