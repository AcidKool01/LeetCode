class CombinationIterator {
    PriorityQueue<String> pq = new PriorityQueue<String>();
    
    public CombinationIterator(String characters, int combinationLength) {
        backtrackSolve(characters, 0, new StringBuilder(), combinationLength);
    }
    
    public String next() {
        return pq.poll();
    }
    
    public boolean hasNext() {
        return !pq.isEmpty();
    }
    
    public void backtrackSolve(String str, int i, StringBuilder sb, int p) {
        if(sb.length()==p) {
            pq.add(sb.toString());
            return;
        }
        
        for (int idx = i; idx<str.length(); idx++) {
            sb.append(str.charAt(idx));
            backtrackSolve(str, idx+1, sb, p);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */