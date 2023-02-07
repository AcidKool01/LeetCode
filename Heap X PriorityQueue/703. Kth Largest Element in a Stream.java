class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    private int K;
    
    public KthLargest(int k, int[] nums) {
        K=k; 
        for (Integer x: nums) {
            pq.add(x);
            if(pq.size()>k) pq.remove();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>K) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */