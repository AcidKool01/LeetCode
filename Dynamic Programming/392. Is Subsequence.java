class Solution {
    
    Boolean[][] dp;
    
    boolean solve (String s, String t, int n, int m) {
        if(n==0) {
            return true;
        } else if(m==0) {
            return false;
        } else if(dp[n][m]!=null) {
            return dp[n][m];
        } else if(s.charAt(n-1)==t.charAt(m-1)) {
            return dp[n][m] = solve(s, t, n-1, m-1);
        } else {
            return dp[n][m] = solve(s, t, n, m-1);
        }
    }
    
    public boolean isSubsequence(String s, String t) {
        dp = new Boolean[s.length()+1][t.length()+1];
        return solve(s, t, s.length(), t.length());
    }
}