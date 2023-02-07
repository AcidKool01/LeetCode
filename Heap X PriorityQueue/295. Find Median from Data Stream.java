class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    private boolean even;
    public MedianFinder() {
        maxHeap = new PriorityQueue();
        minHeap = new PriorityQueue(Collections.reverseOrder());
        even = true;
    }
    
    public void addNum(int num) {
        if(even) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        
        even = !even;
    }
    
    public double findMedian() {
        if(even) {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        } else {
            return minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */