class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dist = new int[N+1];
        Arrays.fill(dist,  Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        ArrayList<int[]>[] adjList = new ArrayList[N+1];
        for(int i=0; i<=N; i++) adjList[i] = new ArrayList<int[]>();
        for(int i=0; i<times.length; i++) {
            int src = times[i][0];
            int dest = times[i][1];
            int cost = times[i][2];
            
            int[] curr = new int[2]; curr[0] = cost; curr[1] = dest;
            adjList[src].add(curr);
        }
        
        dist[K] = 0;
        pq.offer(new int[]{0, K});
        
        while(!pq.isEmpty()) {
            int[] currNode = pq.poll();
            int u = currNode[1];
            
            for(int[] node: adjList[u]) {
                int v = node[1];
                int cost = node[0];
                
                if(dist[v] > dist[u] + cost) {
                    dist[v] = dist[u] + cost;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        
        int res = 0;
        for(int i=1; i<=N; i++) {
            // System.out.println(dist[i] + " ");
            res = Math.max(res, dist[i]);
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}