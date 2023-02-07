class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new LinkedList[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int[] ans = new int[numCourses];
        int k=0;
        int count=0;
        
        for(int i=0; i<numCourses; i++) adj[i] = new LinkedList();
        for (int[] edge: prerequisites) {
            adj[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }
        
        for(int i=0; i<numCourses; i++) 
            if(indegree[i]==0) q.offer(i);
        
        while(!q.isEmpty()) {
            int u = q.poll();
            ans[k++] = u;
            count++;
            for(int v: adj[u]) {
                if(--indegree[v]==0) {
                    q.offer(v);
                }
            }
        }
        
        if(count!=numCourses) return new int[0];
        return ans;
    }
}