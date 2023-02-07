class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        int ans = Integer.MIN_VALUE;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getKey() - a.getKey()));
        
        for (int[] point : points) {
            while(!pq.isEmpty() && point[0] - pq.peek().getValue() > k) {
                pq.poll();
            }
            
            if(!pq.isEmpty()) {
                ans = Math.max(ans, point[0] + point[1] + pq.peek().getKey());
            }
            
            pq.offer(new Pair<Integer, Integer>(point[1] - point[0], point[0]));
        }
        
        return ans;
            
//         int i=0, j=1;
//         while(j<n) {
//             if(Math.abs(points[i][0] - points[j][0]) <= k) {
//                 int f = Math.abs(points[i][0] - points[j][0]) + points[i][1] + points[j][1];
//                 Pair<Integer, Integer> temp = new Pair<Integer, Integer>(Math.abs(points[i][0] - points[j][0]), f);
//                 pq.add(temp);
//                 j++;
//             } else {
                
//                 i++; j++;
//             }
//         }
        
        // for (int i=0; i<n-1; i++) {
            // if(Math.abs(points[i][0] - points[i+1][0]) <= k) {
            //     int f = Math.abs(points[i][0] - points[i+1][0]) + points[i][1] + points[i+1][1];
            //     Pair<Integer, Integer> temp = new Pair<Integer, Integer>(Math.abs(points[i][0] - points[i+1][0]), f);
            //     pq.add(temp);
            // }
        // }
        
        // return pq.peek().getValue();
    }
}