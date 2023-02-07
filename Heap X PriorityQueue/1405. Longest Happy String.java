class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((p1, p2) -> (p2.getValue() - p1.getValue()));
        if(a>0) pq.add(new Pair<Character, Integer>('a', a)); 
        if(b>0) pq.add(new Pair<Character, Integer>('b', b)); 
        if(c>0) pq.add(new Pair<Character, Integer>('c', c));

        while(pq.size()>1) {
            Pair<Character, Integer> curr = pq.poll();
            Pair<Character, Integer> temp = null;
            int flag = 0;
            // if(res.length()>0) System.out.println(curr.getKey() + " ---> " + curr.getValue() + " --> " + res.charAt(res.length()-1));
            // if(curr.getValue()==0) return res.toString();
            // if(curr.getValue()==1) { if(res.charAt(res.length()-1) != curr.getKey())res.append(curr.getKey()); return res.toString(); }
            if(res.length()==0 || res.charAt(res.length()-1) != curr.getKey()) {
                if(curr.getValue() >= 2) {
                    res.append(curr.getKey()); res.append(curr.getKey());
                    temp = new Pair(curr.getKey(), curr.getValue()-2);
                } else if(curr.getValue() == 1) {
                    res.append(curr.getKey());
                    temp = new Pair(curr.getKey(), curr.getValue()-1);
                } 
            } else {
                Pair<Character, Integer> next = pq.poll();
                if(next.getValue() >= 2 && next.getValue() > curr.getValue()) {
                    res.append(next.getKey()); res.append(next.getKey());
                    temp = new Pair(next.getKey(), next.getValue()-2);
                } else if((next.getValue() >=2 && next.getValue() <= curr.getValue()) || next.getValue()==1) {
                    res.append(next.getKey());
                    temp = new Pair(next.getKey(), next.getValue()-1);
                } 
                pq.offer(curr);
            }
            if(temp != null) pq.offer(temp);
        }
        
        if(!pq.isEmpty()) {
            Pair<Character, Integer> madharchod = pq.poll();
            if( res.length()==0 || res.charAt(res.length()-1) != madharchod.getKey()) {
                if(madharchod.getValue() >= 2) {
                    res.append(madharchod.getKey()); res.append(madharchod.getKey());
                } else {
                    res.append(madharchod.getKey()); 
                }    
            }
        }
        
        return res.toString();
    }
}