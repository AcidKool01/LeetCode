class Solution {
    
    public class Comp implements Comparator<Map.Entry<Integer, Integer>>
    {
        public int compare(Map.Entry<Integer, Integer> p1, Map.Entry<Integer, Integer> p2)
        {   
            if(p2.getValue() == p1.getValue()) return p2.getKey() - p1.getKey();
            return p2.getValue()-p1.getValue();   
        }
    }
    
    public int[] kWeakestRows(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int count = 0, f = k-1;
        HashMap<Integer, Integer> hash = new HashMap();
        for (int i=0; i<n; i++) {
            count=0;
            for (int j=0; j<m; j++) {
                if(grid[i][j]==1) {
                    count++;
                }
            }
            hash.put(i, count);
        }
        
        Comp comp = new Comp();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, comp);
        int[] res = new int[k];
        for (Map.Entry entry: hash.entrySet()) {
            pq.add(entry);
            if(pq.size()>k) pq.poll();
        }
        
        while(!pq.isEmpty()) {
            res[f--] = pq.poll().getKey();
        }

        return res;
    }
}