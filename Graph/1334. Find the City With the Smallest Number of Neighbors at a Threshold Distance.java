class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[] visited = new int[n+1];
        ArrayList<int[]>[] adjList = new ArrayList[n];
        for(int i=0; i<n; i++) adjList[i] = new ArrayList<int[]>();
        for(int i=0; i<edges.length; i++) {
            adjList[edges[i][0]].add(new int[]{edges[i][2], edges[i][1]});
            adjList[edges[i][1]].add(new int[]{edges[i][2], edges[i][0]});
        }
        
        for(int i=0; i<n; i++) {
            int k = distanceThreshold;
            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            pq.offer(new int[]{0, i});
            dist[i] = 0;
            
            while(!pq.isEmpty()) {
                int[] currNode = pq.poll();
                int u = currNode[1];
                int cost = currNode[0];
                
                for(int[] node : adjList[u]) {
                    int v = node[1];
                    int w = node[0];
                    
                    if(dist[v] > dist[u] + w) {
                        dist[v] = dist[u] + w;
                        pq.offer(new int[]{dist[v], v});
                    }
                }
            }
            
            for(int j=0; j<n; j++) {                 
                if(k-dist[j] >= 0 && j!=i) visited[i]++; 
            }
        }
        
        int res = 0, count = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(visited[i] <= count) {
                count = visited[i];
                res = i;
            }
        }
        
        return res;
    }
}
