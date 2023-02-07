class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> list = new ArrayList<Integer>();
        int[] indegree = new int[n];
        
        for(List<Integer> edge: edges) {
            indegree[edge.get(1)]++;
        }
        
        for(int i=0; i<n; i++) {
            if(indegree[i]==0) {
                list.add(i);
            }
        }
        
        return list;
    }
}s