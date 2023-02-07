class Solution {
    
    int[][] dp;
    
    public int lcs(int n, int m, String s, String t) {
        if(m<=0) {
            return dp[n][m] = 1;
        } else if(n<=0) {
            return dp[n][m] = 0;
        } else if(dp[n][m] != -1) {
            return dp[n][m];
        } else if(s.charAt(n-1)==t.charAt(m-1)) {
            return dp[n][m] = lcs(n-1, m-1, s, t)+lcs(n-1, m, s, t);
        } else {
            return dp[n][m] = lcs(n-1, m, s, t);
        }
    }
    
    public int numDistinct(String s, String t) {
        dp = new int[s.length()+1][t.length()+1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        lcs(s.length(), t.length(), s, t);
        return dp[s.length()][t.length()];
    }
}