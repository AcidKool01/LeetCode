class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> { return b.getValue() - a.getValue(); });
        int ans = 0, count=0;
        int n = arr.length, size = arr.length;
        
        for (int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }
        
        while(size>n/2) {
            size = size - pq.poll().getValue();
            ans++;
        } 
        
        return ans;
    }
}