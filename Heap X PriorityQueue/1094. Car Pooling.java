class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (trip1, trip2) -> trip1[1] - trip2[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int currCapacity = 0;
        
        for (int[] trip: trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            
            while(!pq.isEmpty() && pq.peek()[0] <= from) {
                currCapacity = currCapacity - pq.poll()[1];
            }
            
            pq.add(new int[]{to, passengers});
            currCapacity += passengers;
            if(currCapacity > capacity) return false;
        } 
        
        return true;
    }
}