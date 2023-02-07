class Solution {
    private HashMap<Integer, Integer> mp;
    private Boolean[][] dp;
    private boolean solve(int[] stones, int i, int prev, int n) {
        if(i==n-1) return true;
        if(i<0 || prev<=0) return false;
        if(dp[i][prev] != null) return dp[i][prev];

        return dp[i][prev] = solve(stones, mp.getOrDefault(stones[i]+prev-1, -1), prev-1, n) || 
                             solve(stones, mp.getOrDefault(stones[i]+prev+1, -1), prev+1, n) ||
                             solve(stones, mp.getOrDefault(stones[i]+prev, -1), prev, n);
    }
    
    public boolean canCross(int[] stones) {
        mp = new HashMap<Integer, Integer>();
        int n = stones.length;
        dp = new Boolean[n+1][n+1];
        for(int i=0; i<n; i++) { mp.put(stones[i], i); }
        return stones[1]==1 && solve(stones, 1, 1, stones.length);
    }
}