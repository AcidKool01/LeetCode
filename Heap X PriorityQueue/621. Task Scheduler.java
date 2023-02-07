class Solution {
    public int leastInterval(char[] tasks, int n) {
        int ans = 0;
        HashMap<Character, Integer> hash = new HashMap<>();
        for (Character x: tasks) hash.put(x, hash.getOrDefault(x, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(hash.entrySet());
        while(!pq.isEmpty()) {
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<Map.Entry<Character, Integer>>();
            int i = 0;
            for (i= n+1; i>0 && !pq.isEmpty(); i-- ) {
                ans++;
                Map.Entry<Character, Integer> curr = pq.poll();
                curr.setValue(curr.getValue()-1);
                
                if(curr.getValue()>0) {
                    waitList.add(curr);
                }
            }
            pq.addAll(waitList);
            if(!pq.isEmpty()) {
                ans += i;
            }
        }
        
        return ans;
    }
}