class Solution {
    
    int[][] dp;
    private int solve(int i, int n, int curr) {
        if(i==n) return 1;
        if(curr==5) {curr = 0; return 0;}
        if(dp[i][curr] != -1) return dp[i][curr];
        
        int ans = 0;
        for(int a=curr; a<=4; a++) {
            ans += solve(i+1, n, a);
        }
        
        return dp[i][curr] = ans;
    }
    
    public int countVowelStrings(int n) {
        dp = new int[n+1][5];
        for(int[] arr: dp) { Arrays.fill(arr, -1); }
        return solve(0, n, 0);
    }
}