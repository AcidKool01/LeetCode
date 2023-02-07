class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Queue<Integer> queue = new LinkedList();
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for(int i=0; i<n; i++) {
            if(color[i]==-1) {
                color[i]=0;
                queue.offer(i);
            
                while(!queue.isEmpty()) {
                    int curr = queue.remove();
                    for (int x: graph[curr]) {
                        if (color[x]==-1) {
                            queue.offer(x);
                            color[x] = 1 - color[curr];
                        } else if(color[x]==color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}