class Solution {
    private List<Integer> result; 
    private HashSet<Integer> visited;
    private void dfs(Map<Integer, ArrayList<Integer>> adj, int u) {
        visited.add(u);
        for(Integer v: adj.get(u)) {
            if(!visited.contains(v)) {
                result.add(v);
                dfs(adj, v);
            }
        }
    }
    
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length+1;
        result = new ArrayList<Integer>();
        visited = new HashSet<Integer>();
        
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int i=0; i<n-1; i++) {
            if(!adj.containsKey(adjacentPairs[i][0])) adj.put(adjacentPairs[i][0], new ArrayList<Integer>());
            if(!adj.containsKey(adjacentPairs[i][1])) adj.put(adjacentPairs[i][1], new ArrayList<Integer>());     
            adj.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]); 
            adj.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]); 
        }
        
        int start = 0;
        for(Map.Entry<Integer, ArrayList<Integer>> entry: adj.entrySet()) {
            if(entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        result.add(start); visited.add(start);
        dfs(adj, start);
        
        int[] res = new int[n];
        for(int i=0; i<n; i++) res[i] = result.get(i);
        
        return res;
    }
}