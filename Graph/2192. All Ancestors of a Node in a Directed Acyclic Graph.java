class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<Integer> adjList[] = new ArrayList[n];
        TreeSet<Integer> dependency[] = new TreeSet[n];
        int[] indegree = new int[n]; 
        for(int i=0; i<n; i++) { adjList[i] = new ArrayList<Integer>(); dependency[i] = new TreeSet<Integer>(); }
        for(int i=0; i<edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            indegree[edges[i][1]]++;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<n; i++) 
            if(indegree[i] == 0) q.offer(i);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int u = q.poll();
                for(Integer v : adjList[u]) {
                    
                    if(dependency[u].size() > 0) {
                        for(Integer x : dependency[u]) {
                            dependency[v].add(x);
                        }
                    }
                    
                    dependency[v].add(u);
                    indegree[v]--;
                    
                    if(indegree[v] == 0) q.add(v);
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for(Integer x: dependency[i]) {
                list.add(x);
            }
            res.add(list);
        }
            
        return res;
    }
}