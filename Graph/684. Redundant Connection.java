class Solution {
    
    public int find(int x, int[] parent) {
        if(parent[x]==x) return x;
        return find(parent[x], parent);
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] res = new int[2];
        for (int i=0; i<=n; i++) parent[i] = i;
        
        for(int i=0; i<n; i++) {
            int x = find(edges[i][0], parent);
            int y = find(edges[i][1], parent);
            
            if(x==y) {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            } else {
                parent[y] = x;
            }
        }
        
        return res;
    }
}