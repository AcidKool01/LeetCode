class Solution {
    private int ans;
    public int minReorder(int n, int[][] connections) {
        ans= 0;
        List<Integer>[] incoming = new ArrayList[n];
        List<Integer>[] outgoing = new ArrayList[n];
        boolean[] visited = new boolean[n];
 
        for(int i=0; i<n; i++) { 
            incoming[i] = new ArrayList<Integer>(); 
            outgoing[i] = new ArrayList<Integer>();
        }
        for (int[] edge: connections) {
            incoming[edge[1]].add(edge[0]);
            outgoing[edge[0]].add(edge[1]);
        }
        
        dfs(0, incoming, outgoing, visited);
        
        return ans;
    }
    
    private void dfs (int u, List<Integer>[] incoming, List<Integer>[] outgoing, boolean[] visited) {
        visited[u] = true;
        for (Integer i: outgoing[u]) {
            if(!visited[i]) {
                ans++;
                dfs(i, incoming, outgoing, visited);
            }
        }
        
        for (Integer i: incoming[u]) {
            if(!visited[i]) {
                dfs(i, incoming, outgoing, visited);
            }
        }
    }
}