class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        int n = orders.length;
        int amount = 0;
        int mod = 1000000007;
        PriorityQueue<int[]> buyBacklog = new PriorityQueue<>((order1, order2) -> (order2[0] - order1[0]));
        PriorityQueue<int[]> sellBacklog = new PriorityQueue<>((order1, order2) -> (order1[0] - order2[0]));
        
        for (int[] x: orders) {
            if(x[2]==0) {
                buyBacklog.add(x); 
            } else {
                sellBacklog.add(x);
            }
            
            while (!buyBacklog.isEmpty() && !sellBacklog.isEmpty() && sellBacklog.peek()[0] <= buyBacklog.peek()[0]) {
                int k = Math.min(buyBacklog.peek()[1], sellBacklog.peek()[1]);
                buyBacklog.peek()[1] -= k;
                sellBacklog.peek()[1] -= k;
                if (buyBacklog.peek()[1] == 0) buyBacklog.poll();
                if (sellBacklog.peek()[1] == 0) sellBacklog.poll();
            }
        }
        
        while(!buyBacklog.isEmpty()) amount = amount%mod + buyBacklog.poll()[1]%mod;
        while(!sellBacklog.isEmpty()) amount = amount%mod + sellBacklog.poll()[1]%mod;
        
        return amount%mod;
    }
}