class Solution {   
    // public void dfs(int u, int[][] graph, boolean[] visited) {
    //     visited[u] = true;
    //     for (int v: graph[u]) {
    //         if(outdegree[v]!=0) {
    //             res.add(u);               
    //         }            
    //         if(!visited[v]) {
    //             dfs(v, graph, visited);
    //         }
    //         visited[v] = true;
    //     }
    // }
    
	// just reverse the graph (like make it outdegree) then apply Kahn's Algo on the reverse graph :) ... itna time sochne mei laga 	   diye lmao.. tho outdegree wala was also correct but even so, bahut ineffecient ho jata, more like BRUTE FORCE :")
	
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList();
        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList();
        
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for (int i=0; i<n; i++) {
            for (int j: graph[i]) {
                indegree[i]++;
                adj.get(j).add(i);
            }
        }
        
        for (int i=0; i<n; i++) {
            if(indegree[i]==0) q.offer(i);
        }
        
        while(!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            for (int v: adj.get(u)) {
                indegree[v]--;
                if(indegree[v]==0) q.add(v);
            }
        }
        
        Collections.sort(res);
        return res;
    }
}