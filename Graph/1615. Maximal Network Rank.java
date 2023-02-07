class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] graph = new int[n][n];
        int[] indegree = new int[n];
        
        for(int[] a : roads) {
            indegree[a[0]]++; indegree[a[1]]++;
            graph[a[0]][a[1]] = 1; graph[a[1]][a[0]] = 1;
        }
        
        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                res = Math.max(res, (indegree[i] + indegree[j]) - graph[i][j]);
            }
        }
        
        return res;
    }
}