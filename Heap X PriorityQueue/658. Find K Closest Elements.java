class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            new Comparator<Pair<Integer, Integer>>(){
            public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b){
    
                if((b.getValue() - a.getValue()) == 0)
                    return b.getKey() - a.getKey();
                return b.getValue() - a.getValue();
            }}
        );
        List<Integer> res = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            pq.offer(new Pair<Integer, Integer>(arr[i], Math.abs(x-arr[i])));
            if(pq.size()>k) pq.poll();
        }
        
        while(!pq.isEmpty()) {
            res.add(pq.poll().getKey());
        }
        
        Collections.sort(res);
        return res;
    }
}