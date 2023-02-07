class Solution {
    List<List<Integer>> res = new LinkedList();
    public void dfs(int[][] graph, int u, List<Integer> temp) {  
        
        if(u==graph.length-1) {
            res.add(new LinkedList<Integer>(temp));
            return;
        }
            
        for (int v: graph[u]) {   
            temp.add(v);
            dfs(graph, v, temp);
            temp.remove(temp.size()-1);
        }
        
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<Integer> temp = new LinkedList();
        temp.add(0);
        dfs(graph, 0, temp);  
        return res;
    }
}