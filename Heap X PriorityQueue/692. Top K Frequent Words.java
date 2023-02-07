class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>( (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());
        List<String> ans = new ArrayList<String>();
        for (String x: words) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
            if(pq.size() > k) pq.poll();
        }
        
        while(!pq.isEmpty()) {
            ans.add(0, pq.poll().getKey());
        }
        
        return ans;
    }
}