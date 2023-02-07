class Solution {
    public String repeatLimitedString(String s, int k) {
        int n = s.length();
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<n; i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<Pair<Character, Integer>>((a, b) -> a.getKey()!=b.getKey() ? b.getKey().compareTo(a.getKey()) : b.getValue()-a.getValue());
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()) pq.offer(new Pair<Character, Integer>(entry.getKey(), entry.getValue()));
        
        while(pq.size() > 1) {
            Pair<Character, Integer> curr = pq.poll();
            Pair<Character, Integer> temp = null;
            if(res.length()==0 || res.charAt(res.length()-1) != curr.getKey()) {
                if(curr.getValue() > k) {
                    for(int i=0; i<k; i++) res.append(curr.getKey());
                    temp = new Pair<Character, Integer>(curr.getKey(), curr.getValue()-k);
                } else {
                    for(int i=0; i<curr.getValue(); i++) res.append(curr.getKey());
                }
            } else {
                Pair<Character, Integer> next = pq.poll();
                res.append(next.getKey());
                // if(next.getValue()-1 >=1) temp = new Pair<Character, Integer>(next.getKey(), next.getValue()-1);
                if(next != null && next.getValue()-1 >= 1) {
                    // for(int i=0; i<k; i++) 
                    // res.append(next.getKey());
                    temp = new Pair<Character, Integer>(next.getKey(), next.getValue()-1);
                } 
                // else {
                //     // for(int i=0; i<next.getValue(); i++) 
                //     res.append(next.getKey());
                // }
                if(curr!=null) pq.offer(curr);
            }
            
            if(temp != null) pq.offer(temp);
        }
        
        if(!pq.isEmpty()) {
            Pair<Character, Integer> bakchod = pq.poll();
            for(int i=0; i<Math.min(k, bakchod.getValue()); i++)res.append(bakchod.getKey());
        }
        
        return res.toString();
    }
}