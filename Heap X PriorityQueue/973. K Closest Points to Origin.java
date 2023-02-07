class Solution {
    
    public class Comp implements Comparator<Pair<Integer, Integer>>
    {
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2)
        {
            return p2.getKey()-p1.getKey();      //max heap;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        Comp comp = new Comp();
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(k, comp);
        
        for(int i=0; i<points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            
            int dist = x*x + y*y;
            
            Pair<Integer, Integer> p = new Pair<>(dist, i);
            
            pq.add(p);
            
            if(pq.size()>k) {
                pq.poll();
            }
        }
        
        int[][] res = new int[k][2];
        
        int i=0;
        while(!pq.isEmpty()) {
            int j=pq.poll().getValue();
            
            res[i][0] = points[j][0];
            res[i][1] = points[j][1];
            
            i++;
        }
        
        return res;
    }
}