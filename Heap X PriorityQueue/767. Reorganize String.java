class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        StringBuilder res= new StringBuilder();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<n; i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(Map.Entry entry: map.entrySet()) {
            Pair<Character, Integer> curr = new Pair(entry.getKey(), entry.getValue());
            pq.add(curr);
        }
        
        while(!pq.isEmpty()) {
            Pair<Character, Integer> curr = pq.poll();
            if(res.length()==0 || curr.getKey() != res.charAt(res.length()-1)) {
                res.append(curr.getKey());
                if(curr.getValue()-1 > 0) pq.offer(new Pair(curr.getKey(), curr.getValue()-1));
            } else {
                if(!pq.isEmpty()) {
                    Pair<Character, Integer> nxt = pq.poll();
                    res.append(nxt.getKey());
     
                    if(nxt.getValue()-1 > 0) pq.offer(new Pair(nxt.getKey(), nxt.getValue()-1));
                    pq.offer(curr);
                } else {
                    return "";
                }
            }
        }
        
        return res.toString();
    }
}