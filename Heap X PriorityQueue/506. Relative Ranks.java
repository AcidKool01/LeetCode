class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        int n = score.length;
        String[] ans = new String[n];
        
        for (int i=0; i<n; i++) {
            Pair<Integer, Integer> temp = new Pair<Integer, Integer>(i, score[i]);
            pq.offer(temp);
        }
        
        int f = 0;
        while(!pq.isEmpty()) {
            Pair<Integer, Integer> curr = pq.poll();
            if(f==0) {
                ans[curr.getKey()] = "Gold Medal";
            } else if (f==1) {
                ans[curr.getKey()] = "Silver Medal";
            } else if (f==2) {
                ans[curr.getKey()] = "Bronze Medal";
            } else {  
                ans[curr.getKey()] = Integer.toString(f+1);
            }
            f++;
        }
        
        return ans;
    }
}