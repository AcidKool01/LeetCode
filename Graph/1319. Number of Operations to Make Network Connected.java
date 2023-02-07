
// TLE :")
// You know why ? It's the Fucking LinkedList..use ArrayList idiot.. because ArrayList.get() is O(1) whereas For LinkedList, it's O(n)!!!

class Solution {
    
    public void dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for(int v: adj.get(u)) {
            if(!visited[v]) {
                dfs(v, adj, visited);
            }
            visited[v] = true;
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        if(n-1 > connections.length) return -1;
        int ans=0;
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new LinkedList();
        
        for(int i=0; i<n; i++) {
            adj.add(new LinkedList<Integer>());
        }
        
        for (int[] arr: connections) {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        
        for (int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, adj, visited);
                ans++;
            }
        }
        
        return ans-1;
    }
}

// Better Solution :)

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] c = new int[n];
        int group = 0, extra = 0;
        for(int i = 0; i < n; i++) c[i] = i;
        for(int[] a : connections)
            if(union(a[0], a[1], c))
                extra ++;
        for(int i = 0; i < n; i++) {
            if(find(i, c) == i)
                group ++;
        }
        return extra >= group - 1 ? group - 1 : -1;
    }
    
    boolean union(int a, int b, int[] c) {
        if(find(a, c) != find(b, c)){
            c[c[a]] = c[b];
            return false;
        }
        else return true;
    }
    
    int find(int a, int[] c) {
        if(c[a] != a) 
            c[a] = find(c[a], c);
        return c[a];
    }
}

